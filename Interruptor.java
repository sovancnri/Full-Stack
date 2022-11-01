import java.util.Scanner;

class ThreadInterrutor extends Thread{
    public void run(){
    try{
        Thread.sleep(60000);
        System.out.println("Better Luck Next Time");
        System.exit(0);
    }catch(InterruptedException e)
    {
        throw new RuntimeException(e);
    }
}
}
public class Interruptor {
    public static void main(String[] args) {
        ThreadInterrutor t = new ThreadInterrutor();
        Scanner sc =new Scanner(System.in);
        System.out.println("Please enter something");
        t.start();
        String s = sc.next();
         
        if(s != null){
            System.out.println("Congratulations!");
            System.exit(0);
        }
    }
}
