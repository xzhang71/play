package cci.lock;

/**
 * Created by xzhang71 on 7/23/14.
 */
public class Philosopher extends Thread {

    private Chopstick left;
    private Chopstick right;

    public Philosopher(Chopstick left, Chopstick right) {
        this.left = left;
        this.right = right;
    }

    public void eat() {
        if (!left.pickUp()) {
            return;
        }
        if (!right.pickUp()) {
            left.putDown();
        }

        for (int i = 0; i < 100; i++) {

        }

        right.putDown();
        left.putDown();
    }

    @Override
    public void run() {

    }
}