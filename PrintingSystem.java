public class PrintingSystem {

    public static void main(String [] args){

        ThreadGroup students = new ThreadGroup("Students");
        ThreadGroup technicians = new ThreadGroup("Technicians");

        LaserPrinter printer = new LaserPrinter("Canon_Image_Class","printer001",students);

        Student student1 = new Student("Chanuka", printer,students);
        Student student2 = new Student("Ravidu", printer,students);
        Student student3 = new Student("Senuri", printer,students);
        Student student4 = new Student("Dlki", printer,students);

        PaperTechnician paperTechnician = new PaperTechnician("John", printer , technicians);
        TonerTechnician tonerTechnician = new TonerTechnician("Harry",printer , technicians);

        student1.start();
        student2.start();
        student3.start();
        student4.start();

        paperTechnician.start();
        tonerTechnician.start();

        try{
            student1.join();
            student2.join();
            student3.join();
            student4.join();
            paperTechnician.join();
            tonerTechnician.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
