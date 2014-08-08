package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhang71 on 8/6/14.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int lastRepeat = -1;
        int maxLength = 0;
        Map<Character, Integer> cache = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cache.containsKey(c)) {
                lastRepeat = Math.max(lastRepeat, cache.get(c));
            }
            cache.put(c, i);
            int runningLength = i - lastRepeat;
            if (runningLength > maxLength) {
                maxLength = runningLength;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
        System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
    }
}