package threads.pro1114;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *
 * @author 王涵威
 * @date 21.6.4 20:17
 */
public class PrintInOrder {
    private static AtomicInteger count;

    public PrintInOrder() {
        count = new AtomicInteger(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (count.get() != 0) {
        }
        printFirst.run();
        count.getAndIncrement();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (count.get() != 1) {
        }
        printSecond.run();
        count.getAndIncrement();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (count.get() != 2) {
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
