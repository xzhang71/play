package leetcode;

/**
 * Created by xzhang71 on 8/10/14.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            if (x == Integer.MIN_VALUE) {
                return false;
            } else {
                return false;
                // return isPalindrome(-x);
            }
        }

        int l = 1;
        while (x / l >= 10) {
            l = l * 10;
        }

        int r = 1;
        while (l > r) {
            if (x / l % 10 != x / r % 10) {
                return false;
            }
            l = l / 10;
            r = r * 10;
        }

        return true;
    }
}