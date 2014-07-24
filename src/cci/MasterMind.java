package cci;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhang71 on 7/23/14.
 */
public class MasterMind {
    public static int[] masterMind(String guess, String solution) {
        int hit = 0;
        int pseudoHit = 0;

        Map<Character, Integer> cache = new HashMap<>();
        for (int i = 0; i < solution.length(); i++) {
            char s = solution.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                hit++;
            } else {
                if (cache.containsKey(s)) {
                    cache.put(s, cache.get(s) + 1);
                } else {
                    cache.put(s, 1);
                }
            }
        }

        for (int i = 0; i < solution.length(); i++) {
            char s = solution.charAt(i);
            char g = guess.charAt(i);

            if (s != g && cache.containsKey(g)) {
                int n = cache.get(g);
                if (n == 1) {
                    cache.remove(g);
                } else {
                    cache.put(g, n - 1);
                }
                pseudoHit++;
            }
        }

        return new int[]{hit, pseudoHit};
    }

    public static void main(String[] args) {
        int[] r = MasterMind.masterMind("BGRB", "GGBR");
        System.out.printf("{%d, %d}", r[0], r[1]);
    }
}
