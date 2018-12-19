package threadsynchronization;

public class ThreadSynchronization {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        ThreadSynchronization threadSynchronization = new ThreadSynchronization();
        
        Thread thread1 = new Thread(new Runnable() {
            @Override
            synchronized public void run() {
                threadSynchronization.countMe();
                System.out.println("The Thread1 is over");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadSynchronization.countMe();
                System.out.println("The Thread2 is over");
            }
        });

        thread1.start();
        thread2.start();
        Thread.sleep(800);

        System.out.println("\nThe value of counter = " + ThreadSynchronization.counter);
    }

    public void countMe() {
        for (int i = 0; i < 1000; i++) {
            ThreadSynchronization.counter++;
        }
    }
}
