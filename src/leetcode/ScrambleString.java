package leetcode;

import java.util.Arrays;

/**
 * Created by xzhang71 on 6/16/14.
 */
public class ScrambleString {

    public static void main(String[] args) {
        ScrambleString obj = new ScrambleString();
        boolean result = obj.isScramble("abc", "bca");
        System.out.println(result);
    }

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            // TODO: ERROR?
            return false;
        }
        return isSrambleGo(s1, s2);
    }

    private boolean isSrambleGo(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if (l1 != l2) return false;

        if (s1.equals(s2)) return true;

        boolean isReverse = true;
        for (int i = 0; i < l1; i++) {
            if (s1.charAt(i) != s2.charAt(l1 - i - 1)) {
                isReverse = false;
                break;
            }
        }
        if (isReverse) return true;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < l1; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }

        for (int i = 1; i < l1; i++) {
            if (isSrambleGo(s1.substring(0, i), s2.substring(0, i)) && isSrambleGo(s1.substring(i, l1), s2.substring(i, l1))) {
                return true;
            }

            if (isSrambleGo(s1.substring(l1 - i, l1), s2.substring(0, i)) && isSrambleGo(s1.substring(0, l1 - i), s2.substring(i, l1))) {
                return true;
            }
        }

        return false;
    }
}
