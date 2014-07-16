package cci;

import java.util.Random;
import java.util.Stack;

public class StackSort {

    /**
     * Sort a stack with another stack
     *
     * @param stack
     */
    public static void sort(Stack<Integer> stack) {
        Stack<Integer> cache = new Stack<>();
        int size = stack.size();

        while (size > 0) {
            int i = size;
            int min = stack.pop();
            i--;
            while (i > 0) {
                int val = stack.pop();
                cache.push(Math.max(min, val));
                min = Math.min(min, val);
                i--;
            }
            stack.push(min);
            size--;

            if (size > 0) {
                int j = size;
                int max = cache.pop();
                j--;
                while (j > 0) {
                    int val = cache.pop();
                    stack.push(Math.min(max, val));
                    max = Math.max(max, val);
                    j--;
                }
                cache.push(max);
                size--;
            }
        }

        while (!cache.isEmpty()) {
            stack.push(cache.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            stack.push(rand.nextInt(100));
        }

        StackSort.sort(stack);
        while (!stack.isEmpty()) {
            System.out.printf("%d ", stack.pop());
        }
    }
}
