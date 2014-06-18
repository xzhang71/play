package cci;

import java.util.Stack;

/**
 * Created by xzhang on 6/18/14.
 * CCI 3.4
 */
public class CCIHanoi {

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        for (int i = 10; i >= 1; i--) {
            stack1.push(i);
        }
        System.out.println("start: ");
        moveDisks(stack1, stack2, stack3);
        System.out.println("end: ");
        System.out.println("result: ");
        for (int i = 10; i >= 1; i--) {
            System.out.println(stack3.pop());
        }
    }

    public static void moveDisks(Stack<Integer> stack1, Stack<Integer> stack2, Stack<Integer> stack3) {
        moveDisksGo(stack1.size(), stack1, stack2, stack3);
    }

    public static void moveDisksGo(int n, Stack<Integer> stack1, Stack<Integer> stack2, Stack<Integer> stack3) {
        if (n <= 0) {
            return;
        }

        moveDisksGo(n - 1, stack1, stack3, stack2);

        int d = stack1.pop();
        stack3.push(d);
        System.out.println("move " + d);

        moveDisksGo(n - 1, stack2, stack1, stack3);

    }
}
