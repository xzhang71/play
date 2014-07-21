package cci;

import java.util.*;

/**
 * Created by xzhang71 on 7/20/14.
 */
public class StringSortByAnagram {
    public static void sort(List<String> input) {
        Map<String, Set<String>> cache = new HashMap<>();

        for (String s : input) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String ss = String.valueOf(chars);
            if (!cache.containsKey(ss)) {
                cache.put(ss, new HashSet<String>());
            }
            cache.get(ss).add(s);
        }

        input.clear();

        for (Set<String> set : cache.values()) {
            for (String s : set) {
                input.add(s);
            }
        }
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("a");
        input.add("ab");
        input.add("abc");
        input.add("c");
        input.add("cb");
        input.add("cba");

        StringSortByAnagram.sort(input);

        for (String s : input) {
            System.out.println(s + " ");
        }
    }
}
