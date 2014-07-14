package cci;

import cci.domain.LinkedNode;

/**
 * Created by xzhang71 on 7/13/14.
 */
public class LinkedNodeDelete {
    public static void delete(LinkedNode node) {
        if (node == null) {
            return;
        }

        while (node.next != null) {
            node.val = node.next.val;
            // IMPORTANT
            if(node.next.next == null) {
                node.next = null;
                break;
            }
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedNode node = new LinkedNode(5, new LinkedNode(6, new LinkedNode(7, null)));
        LinkedNode head = new LinkedNode(0, new LinkedNode(1, new LinkedNode(2, new LinkedNode(3, new LinkedNode(4, node)))));

        LinkedNodeDelete.delete(node);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
