package leetcode;

import leetcode.domain.ListNode;

/**
 * Created by xzhang71 on 6/9/14.
 */
public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        reverseKGroup(n1, 2);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        Pair headPair = reverseKGroupGo(head, k, true);
        ListNode current = headPair.tail;
        while (current.next != null) {
            Pair currentPair = reverseKGroupGo(current.next, k, true);
            current.next = currentPair.head;
            current = currentPair.tail;
        }
        return headPair.head;
    }

    private static Pair reverseKGroupGo(ListNode current, int k, boolean reversable) {
        // assumption, head is not null
        ListNode head = current, tail = current;
        current = current.next;
        tail.next = null;
        int i = k - 1;
        while (i > 0 && current != null) {
            ListNode temp = head;
            head = current;
            current = current.next;
            head.next = temp;
            i--;
        }
        tail.next = current;
        if (i <= 0 || !reversable) {
            return new Pair(head, tail);
        } else {
            return reverseKGroupGo(head, k, false);
        }
    }

}

class Pair {
    ListNode head;
    ListNode tail;

    Pair(ListNode head, ListNode tail) {
        this.head = head;
        this.tail = tail;
    }
}