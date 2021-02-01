public class Student extends Thread{
    private LaserPrinter printer;
    private String studentName;

    Student(String studentName, LaserPrinter printer, ThreadGroup threadGroup){
        super(threadGroup, "Thread : "+ studentName);
        this.printer = printer;
        this.studentName = studentName;

    }

    @Override
    public void run(){
        for(int i =0; i<5; i++){
            Document CON_CWK = new Document(studentName , "Concurrent_CWK " + i ,(int)(Math.random()*25));
            printer.documentPrints(CON_CWK);

            try{
                sleep((int)(Math.random()*1000));
            }catch (InterruptedException e ){
                e.printStackTrace();
            }
        }
    }
}
