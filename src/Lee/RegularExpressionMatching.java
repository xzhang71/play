package lee;

/**
 * Created by xzhang71 on 6/8/14.
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        // time complexity is exponential
        String s = "aaax";
        String p = "a*a*a*y";
        isMatch(s, p);
    }

    public static boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        } else if (s == null || p == null) {
            return false;
        } else {
            return go(s, 0, p, 0);
        }
    }

    public static boolean go(String s, int i, String p, int j) {
        if (i >= s.length() && j >= p.length()) {
            return true;
        }
        if (j >= p.length()) {
            return false;
        }
        if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
            return i < s.length() && equal(s.charAt(i), p.charAt(j)) && go(s, i + 1, p, j + 1);
        }
        // zero
        if (go(s, i, p, j + 2)) {
            return true;
        }
        int k = i;
        // one to many
        while (k < s.length() && equal(s.charAt(k), p.charAt(j))) {
            if (go(s, k + 1, p, j + 2)) {
                return true;
            }
            k++;
        }
        return false;
    }

    private static boolean equal(char a, char b) {
        if (a == '.' || b == '.') return true;
        return a == b;
    }
}
