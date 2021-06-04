package threads.pro114;

import java.util.concurrent.CountDownLatch;

/**
 * 把 CountDownLatch 当初信号量
 * @author 王涵威
 * @date 21.6.4 21:12
 */
public class PrintInOrderCountDownLatch {

    CountDownLatch countDownLatch12, countDownLatch23;

    public PrintInOrderCountDownLatch() {
        countDownLatch12 = new CountDownLatch(1);
        countDownLatch23 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatch12.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        //等待计数器归零再向下执行
        countDownLatch12.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        countDownLatch23.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        //等待计数器归零再向下执行
        countDownLatch23.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}


