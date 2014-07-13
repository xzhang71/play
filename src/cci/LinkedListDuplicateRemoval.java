package cci;

import cci.domain.LinkedNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xzhang71 on 7/13/14.
 */
public class LinkedListDuplicateRemoval {

    public static LinkedNode removeDuplicates(LinkedNode head) {
        if (head == null) {
            return head;
        }

        Set<Integer> vals = new HashSet<>();
        vals.add(head.val);

        LinkedNode current = head;
        while (current.next != null) {
            if (vals.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                vals.add(current.next.val);
                current = current.next;
            }
        }

        return head;
    }

    public static LinkedNode removeDuplicates2(LinkedNode head) {
        if (head == null) {
            return head;
        }

        LinkedNode current = head;
        while (current != null) {
            LinkedNode scanner = current;
            while (scanner.next != null) {
                if (scanner.next.val == current.val) {
                    scanner.next = scanner.next.next;
                } else {
                    scanner = scanner.next;
                }
            }
            current = current.next;
        }

        return head;
    }


    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(0, new LinkedNode(1, new LinkedNode(2, new LinkedNode(3, new LinkedNode(2, new LinkedNode(1, new LinkedNode(0, new LinkedNode(1, null))))))));
        head = LinkedListDuplicateRemoval.removeDuplicates(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

        System.out.println();
        LinkedNode head2 = new LinkedNode(0, new LinkedNode(1, new LinkedNode(2, new LinkedNode(3, new LinkedNode(2, new LinkedNode(1, new LinkedNode(0, new LinkedNode(1, null))))))));
        head2 = LinkedListDuplicateRemoval.removeDuplicates2(head2);
        while (head2 != null) {
            System.out.print(head2.val + " ");
            head2 = head2.next;
        }
    }
}
