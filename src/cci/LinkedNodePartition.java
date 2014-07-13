package cci;

import cci.domain.LinkedNode;

/**
 * Created by xzhang71 on 7/13/14.
 */
public class LinkedNodePartition {

    /**
     * Partition a linked list around a value x.
     *
     * @param head
     * @return
     */
    public static LinkedNode partition(LinkedNode head, int pivot) {
        if (head == null) {
            return head;
        }

        LinkedNode lh = null, rh = null, lc = null, rc = null;
        while (head != null) {
            LinkedNode temp = head;
            head = head.next;
            if (temp.val < pivot) {
                if (lh == null) {
                    lh = temp;
                    lc = temp;
                } else {
                    lc.next = temp;
                    lc = lc.next;
                }
            } else {
                if (rh == null) {
                    rh = temp;
                    rc = temp;
                } else {
                    rc.next = temp;
                    rc = rc.next;
                }
            }
        }

        lc.next = rh;
        rc.next = null;
        return lh;
    }

    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(7, new LinkedNode(6, new LinkedNode(5, new LinkedNode(4, new LinkedNode(3, new LinkedNode(2, new LinkedNode(1, new LinkedNode(0, null))))))));
        head = LinkedNodePartition.partition(head, 3);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
