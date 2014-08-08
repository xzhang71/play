package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhang71 on 8/7/14.
 */
public class ZigZagConversion {

    public String convert(String s, int nRows) {
        List<List<Character>> cache = new ArrayList<>();
        for (int i = 0; i < nRows; i++) {
            cache.add(new ArrayList<Character>());
        }
        int i = 0;
        int count = nRows - 2;
        while (i < s.length()) {
            int j = 0;
            while (i < s.length() && j < nRows) {
                cache.get(j).add(s.charAt(i));
                i++;
                j++;
            }
            j = count;
            while (i < s.length() && j > 0) {
                cache.get(j).add(s.charAt(i));
                i++;
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> l : cache) {
            for (char c : l) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}