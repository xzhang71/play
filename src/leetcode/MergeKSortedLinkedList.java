package leetcode;

import leetcode.domain.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xzhang on 6/9/14.
 */
public class MergeKSortedLinkedList {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;
        Comparator<ListNode> comp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };
        Queue<ListNode> pq = new PriorityQueue<>(lists.size(), comp);
        for (ListNode n : lists) {
            if (n != null) {
                pq.add(n);
            }
        }
        if (pq.isEmpty()) {
            return null;
        }
        ListNode head = pq.poll();
        if (head.next != null) {
            pq.add(head.next);
            head.next = null;
        }
        ListNode current = head;

        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            if (temp.next != null) {
                pq.add(temp.next);
            }
            current.next = temp;
            current = current.next;
            current.next = null;
        }
        return head;
    }
}

