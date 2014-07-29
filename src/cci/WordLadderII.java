package cci;

import java.util.*;

/**
 * Created by xzhang71 on 7/27/14.
 */
public class WordLadderII {

    /**
     * IMPORTANT: Assume dict, start, and end are all lower cases
     *
     * @param dict
     * @param start
     * @param end
     * @return
     */
    public static List<List<String>> getWordLadders(Set<String> dict, String start, String end) {
        Map<String, List<String>> graph = getGraph(dict, start, end);
        return getWordLadders(graph, start, end);
    }

    private static Map<String, List<String>> getGraph(Set<String> dict, String start, String end) {
        Map<String, List<String>> graph = new HashMap<>();
        Queue<String> level = new LinkedList<>();
        Queue<String> nextLevel = new LinkedList<>();
        Set<String> levelVisited = new HashSet<>();
        Set<String> nextLevelVisited = new HashSet<>();

        level.add(end);
        levelVisited.add(end);

        // IMPORTANT: check if graph has start
        while (!graph.containsKey(start) && !level.isEmpty()) {
            while (!level.isEmpty()) {
                String current = level.poll();
                for (String s : getNeighbors(dict, current)) {
                    if (s.equals(start)) {
                        List<String> tempList = graph.get(s);
                        if (tempList == null) {
                            tempList = new ArrayList<>();
                            graph.put(s, tempList);
                        }
                        tempList.add(current);
                    } else if (dict.contains(s) && !levelVisited.contains(s)) {
                        // IMPORTANT: avoid queueing duplicate words
                        if (!nextLevelVisited.contains(s)) {
                            nextLevel.add(s);
                            nextLevelVisited.add(s);
                        }

                        List<String> tempList = graph.get(s);
                        if (tempList == null) {
                            tempList = new ArrayList<>();
                            graph.put(s, tempList);
                        }
                        tempList.add(current);
                    }
                }
            }

            Queue<String> swap = level;
            level = nextLevel;
            nextLevel = swap;
            levelVisited.addAll(nextLevelVisited);
            nextLevelVisited.clear();
        }

        return graph;
    }

    private static List<List<String>> getWordLadders(Map<String, List<String>> graph, String start, String end) {
        List<List<String>> result = new ArrayList<>();

        if (graph.containsKey(start)) {
            Queue<List<String>> cache = new LinkedList<>();
            List<String> initLadder = new ArrayList<>();
            initLadder.add(start);
            cache.add(initLadder);

            while (!cache.isEmpty()) {
                List<String> wordLadder = cache.poll();
                String word = wordLadder.get(wordLadder.size() - 1);
                if (word.equals(end)) {
                    result.add(wordLadder);
                } else {
                    for (String w : graph.get(word)) {
                        List<String> newLadder = new ArrayList<>(wordLadder);
                        newLadder.add(w);
                        cache.add(newLadder);
                    }
                }
            }
        }

        return result;
    }

    private static List<String> getNeighbors(Set<String> dict, String s) {
        List<String> neighbors = new ArrayList<>();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char original = charArr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != original) {
                    charArr[i] = c;
                    String temp = new String(charArr);
                    if (dict.contains(temp)) {
                        neighbors.add(temp);
                    }
                }
            }
            charArr[i] = original;
        }
        return neighbors;
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        // String[] arr = {"lover", "coder", "comer", "toner", "cover", "tower", "coyer", "bower", "honer", "poles", "hover", "lower", "homer", "boyer", "goner", "loner", "boner", "cower", "never", "sower", "asian"};
        String[] arr = {"rat", "pen", "pan", "pet", "pat", "ran"};
        for (String s : arr) {
            dict.add(s);
        }

        List<List<String>> result = WordLadderII.getWordLadders(dict, "rat", "pen");

        for (List<String> l : result) {
            for (String s : l) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}