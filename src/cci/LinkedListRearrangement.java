package cci;

import cci.domain.LinkedNode;

/**
 * Created by xzhang71 on 7/13/14.
 */
public class LinkedListRearrangement {
    public static LinkedNode rearrange(LinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedNode[] hs = partition(head);
        return conquer(hs);
    }

    private static LinkedNode[] partition(LinkedNode head) {
        LinkedNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedNode h1 = head, h2 = slow.next;
        slow.next = null;
        return new LinkedNode[]{h1, h2};
    }

    private static LinkedNode conquer(LinkedNode[] hs) {
        LinkedNode h1 = hs[0], h2 = hs[1];
        LinkedNode head = h1;
        while (h2 != null) {
            LinkedNode temp = h2;
            h2 = h2.next;
            temp.next = h1.next;
            h1.next = temp;
            h1 = h1.next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(0, new LinkedNode(1, new LinkedNode(2, new LinkedNode(3, new LinkedNode(4, new LinkedNode(5, new LinkedNode(6, new LinkedNode(7, null))))))));
        head = LinkedListRearrangement.rearrange(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

        System.out.println();

        LinkedNode head2 = new LinkedNode(0, new LinkedNode(1, new LinkedNode(2, new LinkedNode(3, new LinkedNode(4, new LinkedNode(5, new LinkedNode(6, null)))))));
        head2 = LinkedListRearrangement.rearrange(head2);
        while (head2 != null) {
            System.out.print(head2.val + " ");
            head2 = head2.next;
        }
    }
}
