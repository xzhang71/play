package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhang71 on 6/14/14.
 */
// TODO: FIND THE BUG
public class PermutationSequence {
    public static void main(String[] args) {

    }

    public String getPermutation(int n, int k) {
        // n is guaranteed between 1 and 9 inclusive

        // out of range
        if (k < 0) {
            return "";
        }

        int[] factorials = new int[n + 1];
        factorials[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        // out of range
        if (k > factorials[n]) {
            return "";
        }

        List<Character> lib = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            lib.add((char) ('0' + i));
        }

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(lib.remove(k / factorials[n - 1]));
            k = k % factorials[n - 1];
            n--;
        }

        return sb.toString();
    }
}
