public class LaserPrinter implements ServicePrinter{

    private String printerName;
    private String printerId;
    private int currentPaperLevel;
    private int currentTonerLevel;
    private int noOfDocumentsPrinted;
    private ThreadGroup students;

    LaserPrinter(String printerName , String printerId, ThreadGroup students){
        this.printerName = printerName;
        this.printerId = printerId;
        this.currentPaperLevel = ServicePrinter.fullPaperTray;
        this.currentTonerLevel = ServicePrinter.maximumTonerLevel;
        this.noOfDocumentsPrinted = 0;

        this.students = students;
    }

    @Override
    public synchronized void documentPrints(Document document) {
        messages(Utilities.PRINTING_REQUEST_RECEIVED);

        int documentPages = document.getNumberOfPages();

        while (!enoughPapersToners(documentPages)){
            try{
                messages(Utilities.WAITING_FOR_PRINTING_RESOURCES);
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        messages(Utilities.ENOUGH_PRINTING_RESOURCES);

        currentPaperLevel -= documentPages;
        currentTonerLevel -= documentPages;
        noOfDocumentsPrinted +=1;

        messages("PRINTING " + document.getStudentID() + "'s " + document.getDocumentName()+ " of pages " + document.getNumberOfPages() + "...");
        messages(toString());
        messages(Utilities.PRINTING_DOC_DONE);

        notifyAll();

    }

    @Override
    public synchronized void replaceTonerCartridge() {
        messages(Utilities.TONER_REPLACE_REQUEST_RECEIVED);

        while(hasEnoughToners()){
            try{
                if(stillPrints()){
                    messages(Utilities.WAITING_FOR_TONER_REQUEST);
                    wait(5000);
                }else {
                    messages(Utilities.STUDENT_OUT);
                    break;

                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }

        if(!hasEnoughToners()){
            messages(Utilities.TONER_REPLACING);
            currentTonerLevel = ServicePrinter.maximumTonerLevel;
            System.out.println("Toner Replacing...");
            messages(Utilities.TONER_REPLACE_DONE);
        }
        messages(Utilities.TONER_REPLACE_REQUEST_PROCESSED);
        notifyAll();

    }

    @Override
    public synchronized void refillPaper() {
        messages(Utilities.PAPER_REPLACE_REQUEST_RECEIVED);

        while (paperOverfill()){
            try{
                if(stillPrints()){
                    messages(Utilities.WAITING_FOR_PAPER_REQUEST);
                    wait(5000);
                }else{
                    messages(Utilities.STUDENT_OUT);
                    break;
                }

            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        if(!paperOverfill()){
            messages(Utilities.PAPER_REPLACING);
            currentPaperLevel += ServicePrinter.packSheets;
            System.out.println("Replacing Paper...");
            System.out.println(toString());
            messages(Utilities.PAPER_REPLACE_DONE);
        }

        messages(Utilities.PAPER_REPLACE_REQUEST_PROCESSED);
        notifyAll();

    }

    private void messages(String msg) {
        System.out.println(msg);
    }

    private boolean enoughPapersToners(int documentPages) {
        return currentPaperLevel >= documentPages || currentTonerLevel >= documentPages;
    }

    private boolean hasEnoughToners() {
        return currentTonerLevel > ServicePrinter.minimumTonerLevel;
    }

    private boolean stillPrints() {
        return students.activeCount() > 0;
    }

    private boolean paperOverfill() {
        return currentPaperLevel + ServicePrinter.packSheets > ServicePrinter.fullPaperTray;
    }

    @Override
    public String toString() {
        return "LaserPrinter{" +
                "printerName='" + printerName + '\'' +
                ", printerId='" + printerId + '\'' +
                ", currentPaperLevel=" + currentPaperLevel +
                ", currentTonerLevel=" + currentTonerLevel +
                ", noOfDocumentsPrinted=" + noOfDocumentsPrinted +
                ", students=" + students +
                '}';
    }
}
