package waitandnotifyinthread;

public class WaitAndNotifyInThread {

    private final Object MY_LOCK = this;
    private static double balance = 0;

    public void withdraw(double amount) {
        synchronized (MY_LOCK) {
            if (balance <= 0) {
                try {
                    System.out.println("Waiting for deposite");
                    wait();
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        balance -= amount;

        System.out.println("Withdraw successfully");
        System.out.println("Current balance: " + balance);
    }

    public void deposit(int amount) {
        System.out.println("We are depositing the balance");
        balance += amount;
        System.out.println("Deposit done");

        synchronized (MY_LOCK) {
            notify();
            //notifyAll() to unlock all waiting thread
        }
    }

    public static void main(String[] args) {
        WaitAndNotifyInThread waitAndNotifyInThread = new WaitAndNotifyInThread();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                waitAndNotifyInThread.withdraw(500);
            }
        });
        thread1.setName("Thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }

                waitAndNotifyInThread.deposit(1000);
            }
        });
        thread2.setName("Thread2");

        thread1.start();
        thread2.start();
    }
}
