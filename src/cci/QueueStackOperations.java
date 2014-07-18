package cci;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by xzhang71 on 7/17/14.
 */
public class QueueStackOperations {

    public static void main(String[] args) {
        Queue queue = new LinkedList();

        // returns true upon success, otherwise throws exception
        queue.add(new Object());

        // returns true upon success, otherwise false
        queue.offer(new Object());

        // returns the head of the queue or null if the queue is empty
        queue.poll();


        Stack stack = new Stack();

        //
        stack.add(new Object());

        //
        stack.push(new Object());

        // returns the top of the stack or throws exception if the stack is empty
        stack.pop();
    }
}
