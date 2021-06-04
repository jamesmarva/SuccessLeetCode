package threads.pro1115;

import java.util.concurrent.Semaphore;

/**
 * https://leetcode-cn.com/problems/print-foobar-alternately/solution/duo-xian-cheng-liu-mai-shen-jian-ni-xue-d220n/
 *
 * @author 王涵威
 * @date 21.6.4 21:20
 */
public class PrintFooBarAlternately {

    private int n;

    private Semaphore semaphoreFoo, semaphoreBar;

    public PrintFooBarAlternately(int n) {
        semaphoreFoo = new Semaphore(n);
        semaphoreBar = new Semaphore(n);
        semaphoreFoo.release();
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphoreFoo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphoreBar.release();

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphoreBar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphoreFoo.release();
        }
    }
}
