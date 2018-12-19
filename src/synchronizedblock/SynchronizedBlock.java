package synchronizedblock;

class Bracket {

    public void generate() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                if (i < 5) {
                    System.out.print("[");
                } else {
                    System.out.print("]");
                }
            }
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(25);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}

/*
*synchronized method approache
*Time required = 6000 ms
*
*synchronized block approache
*Time required = 3800 ms
*/

public class SynchronizedBlock {

    public static void main(String[] args) {
        Bracket bracket = new Bracket();

        new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();

                for (int i = 0; i < 5; i++) {
                    bracket.generate();
                }

                long endTime = System.currentTimeMillis();
                System.out.println("The time requied for Thread1 = " + (endTime - startTime));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();

                for (int i = 0; i < 5; i++) {
                    bracket.generate();
                }

                long endTime = System.currentTimeMillis();
                System.out.println("The time requied for Thread2 = " + (endTime - startTime));
            }
        }).start();
    }
}
