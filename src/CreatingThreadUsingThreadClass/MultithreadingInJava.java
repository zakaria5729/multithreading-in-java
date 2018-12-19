package CreatingThreadUsingThreadClass;

import java.util.logging.Level;
import java.util.logging.Logger;

class MyCounter extends Thread {

    private int threadNo;

    public MyCounter(int threadNo) {
        this.threadNo = threadNo;
    }

    public void countMe() {
        for (int i = 1; i <= 9; i++) {

            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyCounter.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Value of i = " + i + " and thread number = " + threadNo);
        }
    }
}

public class MultithreadingInJava {

    public static void main(String[] args) {
        MyCounter myCounter1 = new MyCounter(1);
        MyCounter myCounter2 = new MyCounter(2);

        long startTime = System.currentTimeMillis();
        
        myCounter1.countMe();
        System.out.println("------------------------------------");
        myCounter2.countMe();
        
        long endTime = System.currentTimeMillis();
        System.out.println("Total time required to process = " + (endTime - startTime));

    }
}