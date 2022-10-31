class Employee implements Runnable{

    String ename;

    public Employee(String ename) {
        this.ename = ename;
    }

    public void run(){
        for(int start =0;start <= 10; start++){
            System.out.println(ename+" prints "+start);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


public class TestApp {
    public static void main(String[] args) {

        Employee empone = new Employee("Mini");
        Employee emptwo = new Employee("Mack");


        Thread t1 = new Thread(empone);
        Thread t2 = new Thread(emptwo);

        // empone.start();
        // emptwo.start();

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch()
        for(int start =0;start <= 10; start++){
            System.out.println("Primary Threaded objects prints "+start);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
