package leetcode;

import leetcode.domain.ListNode;

/**
 * Created by xzhang71 on 6/14/14.
 */

//TODO: FIND THE BUG
public class RotateList {

    public ListNode rotateRight(ListNode head, int n) {
        // k is non-negative
        if (head == null) {
            return null;
        }

        if (n == 0) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            if (fast == null) {
                fast = head;
            }
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = head;
        // the following line will not have effect on the head variable in the caller method
        head = slow.next;
        slow.next = null;

        return head;
    }
}
