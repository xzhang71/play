package leetcode;

import leetcode.domain.ListNode;

/**
 * Created by xzhang71 on 6/27/14.
 */
public class SortList {
    public static void main(String[] args) {
        SortList obj = new SortList();

        ListNode a = new ListNode(6);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(2);
        ListNode f = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        ListNode head = obj.sortList(a);
        ListNode current = head;
        while (current != null) {
            System.out.println(current.val + " ");
            current = current.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        int l = 1;
        while (current.next != null) {
            current = current.next;
            l++;
        }

        for (int i = 1; i <= l; i *= 2) {

            ListNode leftHead = head, leftTail = null, rightHead = null, rightTail = null, nextHead = null, previousTail = null;
            int k = 1;

            for (int j = 0; j + i < l; j += i * 2) {

                leftTail = leftHead;

                while (k < i) {
                    leftTail = leftTail.next;
                    k++;
                }

                rightHead = leftTail.next;
                rightTail = rightHead;

                while (k > 1 && rightTail.next != null) {
                    rightTail = rightTail.next;
                    k--;
                }

                nextHead = rightTail.next;

                leftTail.next = null;
                rightTail.next = null;

                ListNode[] r = merge(leftHead, rightHead);
                if (previousTail == null) {
                    head = r[0];
                } else {
                    previousTail.next = r[0];
                }

                previousTail = r[1];
                r[1].next = nextHead;
                leftHead = nextHead;
            }

        }

        return head;
    }

    private ListNode[] merge(ListNode n1, ListNode n2) {
        ListNode newHead;
        if (n1.val < n2.val) {
            newHead = n1;
            n1 = n1.next;
        } else {
            newHead = n2;
            n2 = n2.next;
        }

        ListNode current = newHead;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                current.next = n1;
                n1 = n1.next;
            } else {
                current.next = n2;
                n2 = n2.next;
            }
            current = current.next;
        }

        if (n1 != null) {
            current.next = n1;
        } else {
            current.next = n2;
        }

        while (current.next != null) {
            current = current.next;
        }

        return new ListNode[]{newHead, current};
    }
}
