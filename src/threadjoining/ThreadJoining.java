package threadjoining;

/*
*The join() method causes the currently running threads to stop executing until the thread it joins with completes its task.
*/

public class ThreadJoining implements Runnable {

    public static void main(String[] args) {
        try {
            Thread thread = new Thread(new ThreadJoining());
            thread.start();

            System.out.println("Started");

            thread.join();
            
            System.out.println("Completed");
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }

    }

    @Override
    public void run() {
        System.out.println("Running....");
    }
}
