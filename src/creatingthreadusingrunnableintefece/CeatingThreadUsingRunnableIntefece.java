package creatingthreadusingrunnableintefece;

class MyCounter implements Runnable {
    
    private int threadNo;

    public MyCounter(int threadNo) {
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
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
    }
}
