package synchronizedblock;

class Bracket {

    private final Object myLock = "myLock";
    
    public void generate() {
        /*
        *The synchronized block is appling an entrancing or monitor lock
        *And this lock need not to be exposed to the outside world
        *So the recommended to make use of a private object in order to apply the lock
        *And this private lock not effected any impact to performance
        */
        
        synchronized (myLock) { ////only synchronized this part
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
