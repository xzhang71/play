package cci.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by xzhang71 on 7/23/14.
 */
public class SemaphoreExample {

    private Semaphore semp1, semp2;

    public SemaphoreExample() {
        try {
            semp1 = new Semaphore(1);
            semp2 = new Semaphore(1);

            semp1.acquire();
            semp2.acquire();
        } catch (InterruptedException e) {
            // TODO
        }
    }

    public void firstThread() {
        // do something
        semp1.release();
    }

    public void secondThread() {
        try {
            semp1.acquire();
            semp1.release();
            // do something
            semp2.release();
        } catch (InterruptedException e) {

        }
    }

    public void thirdThread() {
        try {
            semp2.acquire();
            semp2.release();
            // do something
        } catch (InterruptedException e) {

        }
    }
}