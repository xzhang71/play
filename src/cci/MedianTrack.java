package cci;

/**
 * Created by xzhang on 7/10/14.
 */

/**
 * Design an algorithm to find the median of a list of unsorted numbers
 */

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianTrack {

    private PriorityQueue<Integer> top;
    private PriorityQueue<Integer> tail;

    public MedianTrack() {
        top = new PriorityQueue<>();
        tail = new PriorityQueue<>(11, Collections.reverseOrder());
    }

    public void insert(int number) {
        if (top.size() == tail.size()) {
            top.add(number);
        } else {
            tail.add(number);
        }
        tail.add(top.poll());
        top.add(tail.poll());
    }

    public double getMedian() {
        if (top.size() == tail.size()) {
            return 0.5 * (top.peek() + tail.peek());
        } else {
            return top.peek();
        }
    }

    public static void main(String[] args) {
        MedianTrack obj = new MedianTrack();
        obj.insert(3);
        System.out.println(obj.getMedian());

        obj.insert(4);
        System.out.println(obj.getMedian());

        obj.insert(5);
        System.out.println(obj.getMedian());

        obj.insert(1);
        System.out.println(obj.getMedian());

        obj.insert(2);
        System.out.println(obj.getMedian());

        // ...
    }
}
