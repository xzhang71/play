package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhang71 on 6/28/14.
 */
public class LRUCacheMain {
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(1);
        obj.set(2, 1);
        obj.get(2);
        obj.set(3, 2);
        obj.get(2);
        obj.get(3);

    }
}


class LRUCache {

    private int capacity;
    private Map<Integer, LinkedNode> cache;
    private LinkedNode head;
    private LinkedNode tail;

    public LRUCache(int capacity) {
        if (capacity <= 2) {
            // TODO: ERROR
        }
        this.capacity = capacity;
        cache = new HashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            LinkedNode target = cache.get(key);

            reorder(target);

            return target.val;
        } else {
            return -1;
        }
    }

    private void reorder(LinkedNode target) {
        if (target == head) {

        } else if (target == tail) {
            target.left.right = null;
            tail = target.left;
            target.left = null;
            target.right = head;
            head.left = target;
            head = target;
        } else {
            target.left.right = target.right;
            target.right.left = target.left;
            target.left = null;
            target.right = head;
            head.left = target;
            head = target;
        }
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            LinkedNode target = cache.get(key);

            target.val = value;

            reorder(target);
        } else {
            if (capacity == cache.size()) {
                cache.remove(tail.key);
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    tail = tail.left;
                    tail.right = null;
                }
            }

            LinkedNode newNode = new LinkedNode(key, value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.right = head;
                head.left = newNode;
                head = newNode;
            }

            cache.put(key, newNode);
        }
    }

}

class LinkedNode {
    LinkedNode left;
    LinkedNode right;
    int key;
    int val;

    public LinkedNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
