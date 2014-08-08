package leetcode;

/**
 * Created by xzhang71 on 8/7/14.
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        for (int len = charArray.length; len >= 0; len--) {
            for (int i = 0; i <= charArray.length - len; i++) {
                int j = i + len - 1;
                if (isPalindrome(charArray, i, j)) {
                    return s.substring(i, i + len);
                }
            }
        }
        return null;
    }

    public boolean isPalindrome(char[] charArray, int i, int j) {
        while (i < j) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}