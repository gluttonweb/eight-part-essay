package review;

public class TestThread {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        Thread thread = new Thread();
        thread.sleep(5000);
        thread.yield();

        thread.wait();
        thread.join();
        thread.interrupt();
        thread.notify();

        thread.start();
        new ThreadLocal();
        Object o = new Object();
        o.wait();
    }
}
