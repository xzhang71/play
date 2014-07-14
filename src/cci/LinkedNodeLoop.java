package cci;

import cci.domain.LinkedNode;

/**
 * Created by xzhang71 on 7/13/14.
 */
public class LinkedNodeLoop {
    public static LinkedNode beginningOfLoop(LinkedNode head) {
        LinkedNode slow = head, fast = head;

        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        LinkedNode loop1 = new LinkedNode(8, new LinkedNode(9, new LinkedNode(10, new LinkedNode(11, new LinkedNode(12, null)))));
        LinkedNode current = loop1;
        while (current.next != null) {
            current = current.next;
        }
        current.next = loop1;

        LinkedNode loop2 = new LinkedNode(0, null);
        loop2.next = loop2;

        LinkedNode loop3 = new LinkedNode(0, new LinkedNode(1, null));
        loop3.next.next = loop3;

        LinkedNode loop4 = new LinkedNode(0, new LinkedNode(1, new LinkedNode(2, new LinkedNode(3, new LinkedNode(4, new LinkedNode(5, new LinkedNode(6, loop1)))))));

        // case 1 should be 8
        System.out.println(LinkedNodeLoop.beginningOfLoop(loop1).val);
        // case 2 should be 0
        System.out.println(LinkedNodeLoop.beginningOfLoop(loop2).val);
        // case 3 should be 0
        System.out.println(LinkedNodeLoop.beginningOfLoop(loop3).val);
        // case 4 should be 8
        System.out.println(LinkedNodeLoop.beginningOfLoop(loop4).val);
    }
}
