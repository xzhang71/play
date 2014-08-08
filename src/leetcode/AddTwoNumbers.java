package leetcode;

import leetcode.domain.ListNode;

/**
 * Created by xzhang71 on 8/6/14.
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode current = null;
        while (carry != 0 || l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }

            if (current == null) {
                head = new ListNode(carry % 10);
                current = head;
            } else {
                current.next = new ListNode(carry % 10);
                current = current.next;
            }
            carry = carry / 10;
        }

        return head;
    }

    public static void main(String[] args) {

    }
}