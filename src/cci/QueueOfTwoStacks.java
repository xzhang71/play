package cci;

import java.util.Stack;

/**
 * Implement a queue with two stacks
 */
public class QueueOfTwoStacks<T> {

    private Stack<T> left;
    private Stack<T> right;

    public QueueOfTwoStacks() {
        left = new Stack<>();
        right = new Stack<>();
    }

    public T add(T item) {
        return left.push(item);
    }

    public synchronized T poll() {
        if (right.isEmpty()) {
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
        }
        if (right.isEmpty()) {
            return null;
        } else {
            return right.pop();
        }
    }

    public static void main(String[] args) {
        QueueOfTwoStacks<Integer> queue = new QueueOfTwoStacks<>();

        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }

        for (int i = 0; i < 6; i++) {
            System.out.println(queue.poll());
        }

        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }

        for (int i = 0; i < 6; i++) {
            System.out.println(queue.poll());
        }
    }
}
