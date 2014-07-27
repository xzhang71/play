package cci;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xzhang71 on 7/26/14.
 */
public class Smallest {

    public static Queue<Integer> smallest(int[] A, int n) {
        if (n > A.length) {
            // TODO: exception
        }
        Queue<Integer> pq = new PriorityQueue<>(1, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.add(A[i]);
        }
        for (int i = n; i < A.length; i++) {
            pq.add(A[i]);
            pq.poll();
        }
        return pq;
    }

    public static void main(String[] args) {
        int[] A = new int[100];
        for (int i = 0; i < 100; i++) {
            A[i] = 99 - i;
        }

        Queue<Integer> pq = Smallest.smallest(A, 10);
        for (int i : pq) {
            System.out.print(i + " ");
        }
    }
}