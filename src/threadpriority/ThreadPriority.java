package threadpriority;

/*
It is not neccessary that our manually sets thread priory not work properly all the time because JVM controls the actual thread scheduling. But Most of the time manual priority works properly
*/

public class ThreadPriority implements Runnable {

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadPriority());
        t1.setName("A1");
        
        Thread t2 = new Thread(new ThreadPriority());
        t2.setName("A2");
        
        Thread t3 = new Thread(new ThreadPriority());
        t3.setName("A3");
        
        t1.setPriority(Thread.MIN_PRIORITY); //max priority 10
        t2.setPriority(Thread.MAX_PRIORITY); //min priority 1
        //normal priority 5 (main method or thread contains normal priority)
        
        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " & priority: " + Thread.currentThread().getPriority());
    }
}
