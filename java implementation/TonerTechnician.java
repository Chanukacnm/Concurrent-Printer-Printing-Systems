public class TonerTechnician extends Thread{
    private LaserPrinter laserPrinter;

    TonerTechnician(String technicianName , LaserPrinter laserPrinter , ThreadGroup threadGroup){
        super(threadGroup, "Thread : " + technicianName);

        this.laserPrinter = laserPrinter;
    }

    @Override
    public void run(){
        for (int i=0; i<3; i++){
            laserPrinter.replaceTonerCartridge();
            try {
                sleep(Utilities.timeRandomizer());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
