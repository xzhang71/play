package cci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xzhang on 7/10/14.
 */
public class StringPermutation {

    /**
     * Design an algorithm to print all permutations of a string with duplicate characters.
     */

    public static List<String> permute(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }

        result.add("");
        List<String> temp = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            for (String s : result) {
                for (int j = s.lastIndexOf(c) + 1; j <= i; j++) {
                    temp.add(s.substring(0, j) + c + s.substring(j, i));
                }
            }
            List<String> swap = result;
            result = temp;
            temp = swap;
            temp.clear();
        }

        return result;
    }

    /**
     * Check if a string is a permutation of another one
     * Time Complexity O(n)
     * Space Complexity O(n)
     */
    public static boolean isPermutation(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        if (str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Integer> cache = new HashMap<>();
        for (char c : str1.toCharArray()) {
            Integer count = cache.get(c);
            if (count == null) {
                cache.put(c, 1);
            } else {
                cache.put(c, count + 1);
            }
        }

        for (char c : str2.toCharArray()) {
            Integer count = cache.get(c);
            if (count == null || count <= 0) {
                return false;
            }

            cache.put(c, count - 1);
        }

        return true;
    }


    public static void main(String[] args) {
        List<String> result = StringPermutation.permute("cbabcc");
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println(StringPermutation.isPermutation("abbcccddddeeeee", "eeeeeddddcccbba"));
    }
}
