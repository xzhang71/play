package cci;

import cci.domain.LinkedNode;

/**
 * Created by xzhang71 on 7/13/14.
 */
public class LinkedNodeAdd {

    /**
     * Add of two linked list (other variations include minus, multiply, divide, in order or in reverse order)
     *
     * @param left
     * @param right
     * @return
     */
    public static LinkedNode add(LinkedNode left, LinkedNode right) {
        LinkedNode head = null, current = null;
        int carry = 0;
        while (left != null || right != null || carry > 0) {
            if (left != null) {
                carry += left.val;
                left = left.next;
            }

            if (right != null) {
                carry += right.val;
                right = right.next;
            }

            if (head == null) {
                head = new LinkedNode(carry % 10, null);
                current = head;
            } else {
                current.next = new LinkedNode(carry % 10, null);
                current = current.next;
            }

            carry = carry / 10;
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedNode left = new LinkedNode(1, new LinkedNode(1, new LinkedNode(1, null)));
        LinkedNode right = new LinkedNode(9, new LinkedNode(9, new LinkedNode(9, null)));
        LinkedNode r = LinkedNodeAdd.add(left, right);
        while (r != null) {
            System.out.print(r.val);
            r = r.next;
        }

        System.out.println();

        right = new LinkedNode(9, new LinkedNode(9, new LinkedNode(9, new LinkedNode(9, null))));
        r = LinkedNodeAdd.add(left, right);
        while (r != null) {
            System.out.print(r.val);
            r = r.next;
        }

    }
}
