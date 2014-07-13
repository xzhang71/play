package cci;

import cci.domain.LinkedNode;

/**
 * Created by xzhang71 on 7/13/14.
 */
public class LinkedNodeFindKthToLast {

    /**
     * Find the kth to last element of a singly linked list.
     *
     * @param head
     * @param k
     * @return
     */
    public static LinkedNode kthToLast(LinkedNode head, int k) {
        if (head == null) {
            return null;
        }

        LinkedNode fast = head;
        while (k >= 0 && fast != null) {
            k--;
            fast = fast.next;
        }

        if (k >= 0) {
            return null;
        }

        LinkedNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(0, new LinkedNode(1, new LinkedNode(2, new LinkedNode(3, new LinkedNode(4, new LinkedNode(5, new LinkedNode(6, new LinkedNode(7, null))))))));
        for (int k = 0; k < 10; k++) {
            LinkedNode kth = LinkedNodeFindKthToLast.kthToLast(head, k);
            if (kth == null) {
                System.out.println("null");
            } else {
                System.out.println(kth.val);
            }
        }
    }
}
