package threadjoining;

public class ThreadJoining2 {

    private int counter = 0;

    public static void main(String[] args) {
        ThreadJoining2 joining2 = new ThreadJoining2();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                for (int i = 0; i < 1000; i++) {
                    joining2.counter++;
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                for (int i = 0; i < 1000; i++) {
                    joining2.counter++;
                }
            }
        });

        try {
            thread2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Value of counter = " + joining2.counter);
    }
}
