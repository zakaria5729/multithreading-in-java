package creatingthreadusingrunnableintefece;

import java.util.Random;

/*
*Since Java is not support multiple inheritence,
*so if a class inherit another class then this parent class can not inherit the Thread class.
*And thats why we need Runnable interface to implements the Thread with one or more than one.
*/

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
                Thread.sleep(random.nextInt(300)); //range 0 to 300
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            System.out.println("Value of i = " + i + " and thread number = " + threadNo);
        }
    }
}

public class CeatingThreadUsingRunnableIntefece {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyCounter(1));
        Thread thread2 = new Thread(new MyCounter(2));

        thread1.start();
        thread2.start();
        
        //thread with annonymous
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 9; i++) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    System.out.println(i);
                }
            }
        }).start();
    }
}
