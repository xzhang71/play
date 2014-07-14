package cci;

import cci.domain.LinkedNode;

import java.util.Stack;

/**
 * Created by xzhang71 on 7/13/14.
 */
public class LinkedNodePalindrome {

    /**
     * Check if a linked list is a palindrome.
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(LinkedNode head) {
        if (head == null) {
            return false;
        }

        Stack<Integer> cache = new Stack<>();
        LinkedNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            cache.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        // IMPORTANT: slow is not pushed into the stack yet
        if (fast == null) {
            // odd number of elements
        } else {
            // even number of elements
            cache.add(slow.val);
        }

        slow = slow.next;
        while (slow != null) {
            if (slow.val != cache.pop()) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args) {
        // true
        LinkedNode head1 = new LinkedNode(0, new LinkedNode(1, new LinkedNode(2, new LinkedNode(1, new LinkedNode(0, null)))));
        System.out.println(LinkedNodePalindrome.isPalindrome(head1));

        // true
        LinkedNode head2 = new LinkedNode(0, new LinkedNode(1, new LinkedNode(2, new LinkedNode(2, new LinkedNode(1, new LinkedNode(0, null))))));
        System.out.println(LinkedNodePalindrome.isPalindrome(head2));

        // false
        LinkedNode head3 = new LinkedNode(0, new LinkedNode(1, new LinkedNode(2, new LinkedNode(3, new LinkedNode(4, new LinkedNode(5, null))))));
        System.out.println(LinkedNodePalindrome.isPalindrome(head3));

        // true
        LinkedNode head4 = new LinkedNode(0, null);
        System.out.println(LinkedNodePalindrome.isPalindrome(head4));
    }
}
