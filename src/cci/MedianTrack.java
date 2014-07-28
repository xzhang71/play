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
    private PriorityQueue<Integer> bottom;

    public MedianTrack() {
        top = new PriorityQueue<>();
        bottom = new PriorityQueue<>(11, Collections.reverseOrder());
    }

    public void insert(int n) {
        if (top.size() == bottom.size()) {
            top.add(n);
        } else {
            bottom.add(n);
        }
        bottom.add(top.poll());
        top.add(bottom.poll());
    }

    public double getMedian() {
        if (top.size() == bottom.size()) {
            return (top.peek() + bottom.peek()) * 0.5;
        } else {
            return top.peek();
        }
    }

    public static void main(String[] args) {
        MedianTrack obj = new MedianTrack();
        obj.insert(3);
        System.out.println(obj.getMedian()); // 3.0

        obj.insert(4);
        System.out.println(obj.getMedian()); // 3.5

        obj.insert(5);
        System.out.println(obj.getMedian()); // 4.0

        obj.insert(1);
        System.out.println(obj.getMedian()); // 3.5

        obj.insert(2);
        System.out.println(obj.getMedian()); // 3.0

        // ...
    }
}
