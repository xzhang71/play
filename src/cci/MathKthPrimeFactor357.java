package cci;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xzhang71 on 7/18/14.
 */
public class MathKthPrimeFactor357 {

    public static int findKth(int k) {
        if (k <= 0) {
            return 0;
        }

        Queue<Integer> q3 = new LinkedList<>(), q5 = new LinkedList<>(), q7 = new LinkedList<>();

        q3.add(3);
        q5.add(5);
        q7.add(7);

        int val = 0;
        for (int i = 1; i <= k; i++) {
            val = Math.min(Math.min(q3.peek(), q5.peek()), q7.peek());
            if (q3.peek() == val) {
                q3.poll();
                q3.add(val * 3);
                q5.add(val * 5);
                q7.add(val * 7);
            } else if (q5.peek() == val) {
                q5.poll();
                q5.add(val * 5);
                q7.add(val * 7);
            } else {
                q7.poll();
                q7.add(val * 7);
            }
        }

        return val;
    }

    public static void main(String[] args) {
        for (int k = 0; k < 20; k++) {
            System.out.println(k + "th = " + MathKthPrimeFactor357.findKth(k));
        }
    }
}
