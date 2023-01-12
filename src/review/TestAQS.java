package review;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class TestAQS {

    public native void dd();

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        System.out.println(20 >> 1);

        CountDownLatch countDownLatch = new CountDownLatch(10);
        countDownLatch.countDown();
        countDownLatch.await();

        Semaphore semaphore = new Semaphore(10);
        semaphore.tryAcquire(1); // 立即返回获取结果
        semaphore.acquire(); // 未获取到则阻塞
        semaphore.release();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        cyclicBarrier.await();
        cyclicBarrier.reset();

    }
}
