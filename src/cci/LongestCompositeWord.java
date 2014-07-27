package cci;

import java.util.*;

/**
 * Created by xzhang71 on 7/26/14.
 */
public class LongestCompositeWord {

    public static String find(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String a, String b) {
                return b.length() - a.length();
            }
        });

        Map<String, Boolean> cache = new HashMap<>();
        for (String w : words) {
            cache.put(w, true);
        }

        for (String w : words) {
            if (isValid(w, true, cache)) {
                return w;
            }
        }

        return null;
    }

    private static boolean isValid(String word, boolean isOriginalWord, Map<String, Boolean> cache) {
        if (!isOriginalWord && cache.containsKey(word) && cache.get(word)) {
            return true;
        }

        for (int i = 1; i < word.length(); i++) {
            String firstHalf = word.substring(0, i);
            String secondHalf = word.substring(i, word.length());
            if (cache.containsKey(firstHalf) && cache.get(firstHalf) && isValid(secondHalf, false, cache)) {
                cache.put(word, true);
                return true;
            }
        }

        cache.put(word, false);
        return false;
    }

    public static void main(String[] args) {
        String[] words = {"cat", "banana", "dog", "walk", "walker", "hot", "hotdog", "sky", "skywalker"};
        System.out.println(LongestCompositeWord.find(words));
    }
}