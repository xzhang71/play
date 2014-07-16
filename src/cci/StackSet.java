package cci;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xzhang71 on 7/14/14.
 */
public class StackSet<T> {

    private int threshold;
    private List<Stack<T>> stacks;

    public StackSet(int threshold) {
        this.threshold = threshold;
        stacks = new ArrayList<>();
    }

    private Stack<T> getLastStack() {
        if (stacks.isEmpty()) {
            return null;
        } else {
            return stacks.get(stacks.size() - 1);
        }
    }

    public T push(T item) {
        Stack<T> lastStack = getLastStack();
        if (lastStack == null || lastStack.size() >= threshold) {
            Stack<T> stack = new Stack<>();
            stack.push(item);
            stacks.add(stack);
        } else {
            lastStack.add(item);
        }
        return item;
    }

    public synchronized T pop() {
        while (getLastStack() != null && getLastStack().isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        Stack<T> lastStack = getLastStack();
        if (lastStack == null) {
            return null;
        } else {
            T val = lastStack.pop();
            if (lastStack.isEmpty()) {
                stacks.remove(lastStack);
            }
            return val;
        }
    }

    public synchronized T popAt(int index) {
        return stacks.get(index).pop();
    }

    public static void main(String[] args) {
        StackSet<Integer> stack = new StackSet<>(2);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(stack.popAt(i));
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(stack.popAt(i));
        }

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }
    }
}
