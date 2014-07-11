package cci;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhang on 7/10/14.
 */
public class StringPermutation {

    /**
     * Design an algorithm to print all permutations of a string with duplicate characters.
     */

    public static List<String> permutation(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }

        return permutationGo(str, 0);
    }

    private static List<String> permutationGo(String str, int index) {
        List<String> result = new ArrayList<>();
        // attention >=
        if (index >= str.length()) {
            result.add("");
            return result;
        }

        char c = str.charAt(index);
        List<String> subresult = permutationGo(str, index + 1);
        for (String s : subresult) {
            for (int i = 0; i <= s.length(); i++) {
                String ns = s.substring(0, i) + c + s.substring(i, s.length());
                result.add(ns);
                while (i < s.length() && s.charAt(i) == c) {
                    i++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> result = StringPermutation.permutation("abb");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
