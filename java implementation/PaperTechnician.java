public class PaperTechnician extends Thread{

    private LaserPrinter printer;
    //private String technicianName;

    PaperTechnician(String technicianName , LaserPrinter LaserPrinter , ThreadGroup threadGroup){
        super(threadGroup, "Thread : "+ technicianName);
        this.printer = LaserPrinter;
        //this.technicianName = technicianName;
    }

    @Override
    public void run(){
        for(int i = 0; i<3; i++){
            printer.refillPaper();
            try{
                sleep(Utilities.timeRandomizer());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
