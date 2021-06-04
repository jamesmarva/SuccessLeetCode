package threads.pro1114;

import java.util.concurrent.Semaphore;

/**
 * 〈功能概述〉<br>
 *
 * @author 王涵威
 * @date 21.6.4 20:44
 */
public class PrintInOrderWithSemaphore {

    private Semaphore two = new Semaphore(0);
    private Semaphore three = new Semaphore(0);
    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        two.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        two.acquire();
        printSecond.run();
        three.release();

    }

    public void third(Runnable printThird) throws InterruptedException {
        three.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}
