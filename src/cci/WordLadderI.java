package cci;

import java.util.*;

/**
 * Created by xzhang71 on 7/27/14.
 */
public class WordLadderI {

    /**
     * IMPORTANT: assume dict, start, and end are in lower cases
     *
     * @param dict
     * @param start
     * @param end
     * @return
     */
    public static List<String> wordLadder(Set<String> dict, String start, String end) {
        if (dict == null || start == null || end == null || start.length() != end.length()) {
            throw new RuntimeException("invalid input");
        }

        Queue<String> level = new LinkedList<>();
        Queue<String> nextLevel = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> track = new HashMap<>();

        level.add(end);
        visited.add(end);

        while (!level.isEmpty()) {
            while (!level.isEmpty()) {
                String current = level.poll();
                for (String s : nextLevel(current)) {
                    if (dict.contains(current) && !visited.contains(s)) {
                        if (s.equals(start)) {
                            List<String> ladder = new ArrayList<>();
                            ladder.add(start);
                            while (current != null) {
                                ladder.add(current);
                                current = track.get(current);
                            }
                            return ladder;
                        } else {
                            nextLevel.add(s);
                            visited.add(s);
                            track.put(s, current);
                        }
                    }
                }
            }
            Queue<String> swap = level;
            level = nextLevel;
            nextLevel = swap;
        }

        return new ArrayList<>();
    }

    private static List<String> nextLevel(String s) {
        List<String> nextLevel = new ArrayList<>();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char original = charArr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != original) {
                    charArr[i] = c;
                    nextLevel.add(new String(charArr));
                }
            }
            charArr[i] = original;
        }
        return nextLevel;
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("damp");
        dict.add("lamp");
        dict.add("limp");
        dict.add("lime");
        dict.add("like");
        String start = "damp";
        String end = "like";

        List<String> ladder = WordLadderI.wordLadder(dict, start, end);
        for (String s : ladder) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}