package cci;

import java.util.Stack;

/**
 * Created by xzhang71 on 7/14/14.
 */
public class StackTrackingMinimum extends Stack<Integer> {

    private Stack<Integer> minStack;

    public StackTrackingMinimum() {
        super();
        this.minStack = new Stack<>();
    }


    @Override
    public Integer push(Integer item) {
        Integer val = super.push(item);
        if (minStack.isEmpty() || item <= minStack.peek()) {
            minStack.push(item);
        }
        return val;
    }

    @Override
    public synchronized Integer pop() {
        Integer val = super.pop();
        if (val != null && val == minStack.peek()) {
            minStack.pop();
        }
        return val;
    }

    public Integer min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        StackTrackingMinimum stack = new StackTrackingMinimum();
        for (int i = 9; i >= 0; i--) {
            stack.push(i);
        }

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            System.out.printf("min = %s, pop = %s\n", stack.min(), stack.pop());
        }
    }
}
