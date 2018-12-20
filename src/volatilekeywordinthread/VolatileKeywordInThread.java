package volatilekeywordinthread;

/*
*Some scenario when your thread is depending on a variable and for optimization purposes java can cache the value of the variable and if you already updated the value of the variable java sometimes gets the old value from the cache.

In this scenario we used volatile keyword. That means java never caching this variable.
*/

public class VolatileKeywordInThread {

    volatile public static int flag = 0;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (flag == 0) {
                        System.out.println("Running...");
                    } else {
                        break;
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                flag = 1;
                System.out.println("Flag value updated");
            }
        }).start();
    }
}
