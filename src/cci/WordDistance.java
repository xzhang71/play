package cci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xzhang71 on 7/26/14.
 */
public class WordDistance {

    public static int minDistance(String[] words, String word1, String word2) {
        int minDistance = -1;
        int index1 = -1;
        int index2 = -1;

        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                index1 = i;
                if (index2 != -1) {
                    if (minDistance == -1) {
                        minDistance = index1 - index2;
                    } else {
                        minDistance = Math.min(minDistance, index1 - index2);
                    }
                }
            } else if (word2.equals(words[i])) {
                index2 = i;
                if (index1 != -1) {
                    if (minDistance == -1) {
                        minDistance = index2 - index1;
                    } else {
                        minDistance = Math.min(minDistance, index2 - index1);
                    }
                }
            }
        }

        return minDistance;
    }

    public static Map<String, List<Integer>> cache = new HashMap<>();

    public static void init(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (!cache.containsKey(words[i])) {
                cache.put(words[i], new ArrayList<Integer>());
            }
            cache.get(words[i]).add(i);
        }
    }

    public static int minDistance(String word1, String word2) {
        if (!cache.containsKey(word1) || !cache.containsKey(word2)) {
            return -1;
        }
        List<Integer> list1 = cache.get(word1);
        List<Integer> list2 = cache.get(word2);

        int i = 0;
        int j = 0;
        int minDistance = Math.abs(list1.get(i) - list2.get(j));

        while (i < list1.size() && j < list2.size()) {
            int p1 = list1.get(i);
            int p2 = list2.get(j);
            if (p1 > p2) {
                j++;
                minDistance = Math.min(minDistance, p1 - p2);
            } else {
                i++;
                minDistance = Math.min(minDistance, p2 - p1);
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {
        String[] words = {"a", "a", "b", "a", "b", "c", "a", "b", "c", "d", "a", "b", "c", "d", "e"};
        System.out.println(WordDistance.minDistance(words, "a", "e"));
        WordDistance.init(words);
        System.out.println(WordDistance.minDistance("a", "e"));
    }
}