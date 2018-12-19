package threadsynchronization;

public class ThreadSynchronization {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        ThreadSynchronization threadSynchronization1 = new ThreadSynchronization();
        ThreadSynchronization threadSynchronization2 = new ThreadSynchronization();
        
        Thread thread1 = new Thread(new Runnable() {
            @Override
            synchronized public void run() {
                threadSynchronization1.countMe();
                System.out.println("The Thread1 is over");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadSynchronization2.countMe(); //now sometimes the thread is getting inconsistence results/issues beacuse two object use a single static variable
                System.out.println("The Thread2 is over");
            }
        });

        thread1.start();
        thread2.start();
        Thread.sleep(800);

        System.out.println("\nThe value of counter = " + ThreadSynchronization.counter);
    }

    /*
    *synchronized keyword applies a lock and locks are derived or related to each object.
    *synchronized keyword can only run a Thread at a time with one object and it gives a lock of this synchronized method.
    *Whenover we are making a different object with Thread then
    *synchronized keyword makes different locks for each objects with Thread
    */
    synchronized public void countMe() {
        for (int i = 0; i < 1000; i++) {
            ThreadSynchronization.counter++;
        }
    }
}
