package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhang71 on 6/8/14.
 */
public class RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        return go(s, 0, p, 0);
    }

    public static boolean go(String s, int sIndex, String p, int pIndex) {
        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }

        if (pIndex == p.length()) {
            return false;
        }

        if (sIndex == s.length()) {
            return pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*' && go(s, sIndex, p, pIndex + 2);
        }

        if (pIndex == p.length() - 1 || p.charAt(pIndex + 1) != '*') {
            return (p.charAt(pIndex) == '.' || s.charAt(sIndex) == p.charAt(pIndex)) && go(s, sIndex + 1, p, pIndex + 1);
        }

        if (go(s, sIndex, p, pIndex + 2)) {
            return true;
        }

        int i = sIndex;
        while (i < s.length() && (p.charAt(pIndex) == '.' || s.charAt(i) == p.charAt(pIndex))) {
            if (go(s, i + 1, p, pIndex + 2)) {
                return true;
            }
            i++;
        }

        return false;
    }

    public static boolean isMatch2(String s, String p) {
        List<String> sl = new ArrayList<>();
        int k = 0;
        while (k < s.length()) {
            sl.add(s.substring(k, k + 1));
            k++;
        }

        List<String> pl = new ArrayList<>();
        k = 0;
        while (k < p.length()) {
            if (k + 1 < p.length() && p.charAt(k + 1) == '*') {
                pl.add(p.substring(k, k + 2));
                k += 2;
            } else {
                pl.add(p.substring(k, k + 1));
                k++;
            }
        }

        boolean[][] cache = new boolean[sl.size() + 1][pl.size() + 1];
        cache[0][0] = true;

        for (int c = 1; c < cache[0].length; c++) {
            String pStr = pl.get(c - 1);
            for (int r = 0; r < cache.length; r++) {
                if (r == 0) {
                    cache[r][c] = cache[r][c - 1] && pStr.length() == 2;
                } else {
                    String sStr = sl.get(r - 1);
                    if (pStr.length() == 1) {
                        cache[r][c] = cache[r - 1][c - 1] && (pStr.equals(".") || pStr.equals(sStr));
                    } else {
                        cache[r][c] = cache[r][c - 1] ||
                                ((cache[r - 1][c - 1] || cache[r - 1][c]) && (pStr.charAt(0) == '.' || pStr.charAt(0) == sStr.charAt(0)));
                    }
                }
            }
        }

        return cache[sl.size()][pl.size()];
    }

    public static void main(String[] args) {
        String s = "aaax";
        String p = "a*aaaa*x";
        System.out.println(isMatch(s, p));
        System.out.println(isMatch2(s, p));
    }
}