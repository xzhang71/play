package leetcode;

import java.util.*;

/**
 * Created by xzhang71 on 7/5/14.
 */
public class WordLadderII {

    public static void main(String[] args) {
        WordLadderII obj = new WordLadderII();
        Set<String> dict = new HashSet<>();
        //String[] arr = {"lover", "coder", "comer", "toner", "cover", "tower", "coyer", "bower", "honer", "poles", "hover", "lower", "homer", "boyer", "goner", "loner", "boner", "cower", "never", "sower", "asian"};
        String[] arr = {"rat", "pen", "pan", "pet", "pan", "pat", "ran"};
        for (String s : arr) {
            dict.add(s);
        }

        List<List<String>> result = obj.findLadders("rat", "pen", dict);

        for (List<String> l : result) {
            for (String s : l) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        Map<String, List<String>> graph = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(end);

        while (!queue.isEmpty()) {
            List<String> words = new ArrayList<>();
            while (!queue.isEmpty()) {
                String s = queue.poll();
                if (dict.contains(s)) {
                    words.add(s);
                    dict.remove(s);
                }
            }

            for (String w : words) {
                char[] wordArray = w.toCharArray();

                for (int i = 0; i < wordArray.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char originalChar = wordArray[i];
                        wordArray[i] = c;
                        String nw = new String(wordArray);

                        if (nw.equals(start)) {
                            List<String> list = graph.get(nw);
                            if (list == null) {
                                list = new ArrayList<>();
                                graph.put(nw, list);
                            }
                            list.add(w);
                        } else if (dict.contains(nw)) {
                            List<String> list = graph.get(nw);
                            if (list == null) {
                                list = new ArrayList<>();
                                graph.put(nw, list);
                            }
                            list.add(w);
                            queue.add(nw);
                        }

                        wordArray[i] = originalChar;
                    }
                }
            }

            if (graph.containsKey(start)) {
                break;
            }
        }

        List<List<String>> result = new ArrayList<>();

        if (graph.containsKey(start)) {
            Queue<List<String>> ladderQueue = new LinkedList<>();
            List<String> initLadder = new ArrayList<>();
            initLadder.add(start);
            ladderQueue.add(initLadder);

            while (!ladderQueue.isEmpty()) {
                List<String> ladder = ladderQueue.poll();
                String word = ladder.get(ladder.size() - 1);

                if (word.equals(end)) {
                    result.add(ladder);
                } else {
                    for (String s : graph.get(word)) {
                        List<String> newLadder = new ArrayList<>(ladder);
                        newLadder.add(s);
                        ladderQueue.add(newLadder);
                    }
                }
            }
        }

        return result;
    }

}
