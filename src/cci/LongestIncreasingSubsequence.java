package cci;

/**
 * Created by xzhang71 on 7/21/14.
 */
public class LongestIncreasingSubsequence {

    public static int longestIncreasingSubsequence(int[] input) {
        if (input.length == 0) {
            return 0;
        }

        int[] cache = new int[input.length];
        cache[0] = 1;
        int longest = 1;

        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j]) {
                    cache[i] = cache[j] + 1;
                    longest = Math.max(longest, cache[i]);
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] input = {0, 2, 1, 4, 3, 6, 5, 8, 7, 9};
        System.out.println(LongestIncreasingSubsequence.longestIncreasingSubsequence(input));
    }
}
