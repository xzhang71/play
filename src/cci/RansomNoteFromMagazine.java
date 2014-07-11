package cci;

import java.util.HashMap;

/**
 * Created by xzhang on 7/10/14.
 */
public class RansomNoteFromMagazine {
    /**
     * A ransom note can be formed by cutting words out of a magazine to form a new sentence. How would you figure out if a ransom note (represented as a string) can be formed from a given magazine (string)?
     */

    public static boolean ransom(String magazine, String ransom) {
        if (magazine == null || ransom == null) {
            // TODO: ERROR
            return false;
        }

        HashMap<Character, Integer> cache = new HashMap<>();
        for (char c : ransom.toCharArray()) {
            // something like the following should be ignored
            if (c == ' ' || c == '\n' || c == '\r') {
                continue;
            }
            if (cache.containsKey(c)) {
                cache.put(c, cache.get(c) + 1);
            } else {
                cache.put(c, 1);
            }
        }

        for (char c : magazine.toCharArray()) {
            if (cache.containsKey(c)) {
                int n = cache.get(c);
                if (n == 0) {
                    return false;
                }
                cache.put(c, n - 1);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(RansomNoteFromMagazine.ransom("This main article about dog and dog lovers is very interesting though.", "You are dead man."));
    }
}
