package cci;

import java.util.Stack;

/**
 * Created by xzhang on 6/18/14.
 */
public class QueueWithTwoStacks<T> {
    Stack<T> stack1 = new Stack<>();
    Stack<T> stack2 = new Stack<>();

    public void add(T value) {
        stack1.push(value);
    }

    public T peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }

        if (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }

        return null;
    }

    public T poll() {
        T value = peek();
        stack2.pop();
        return value;
    }

    public boolean isEmpty() {
        return stack1.size() + stack2.size() == 0;
    }


    public static void main(String[] args) {
        QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
