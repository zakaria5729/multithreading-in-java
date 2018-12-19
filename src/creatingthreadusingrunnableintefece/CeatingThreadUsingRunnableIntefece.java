package creatingthreadusingrunnableintefece;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class MyCounter implements Runnable {

    private int threadNo;

    public MyCounter(int threadNo) {
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 1; i <= 9; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            System.out.println("Value of i = " + i + " and thread number = " + threadNo);
        }
    }
}

public class CeatingThreadUsingRunnableIntefece {

    public static void main(String[] args) {
        //thread with annonymous
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 9; i++) {
                    try {
                        System.out.println((System.currentTimeMillis())/60000+" anno");
                        Thread.sleep(300);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    System.out.println(i+" a");
                }
            }
        }).start();

        Thread thread1 = new Thread(new MyCounter(1));
        Thread thread2 = new Thread(new MyCounter(2));

        thread1.start();
        System.out.println((System.currentTimeMillis())/60000+" one");
        thread2.start();
        System.out.println((System.currentTimeMillis())/60000+" two");
    }
}
