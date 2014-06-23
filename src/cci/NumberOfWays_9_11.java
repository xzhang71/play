package cci;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhang on 6/23/14.
 */
public class NumberOfWays_9_11 {

    public static void main(String[] args) {
        String exp = "1^0|0|1";
        System.out.println(numberOfWays(exp.toCharArray(), 0, exp.length() - 1, 0, new HashMap<String, Integer>()));
    }

    public static int numberOfWays(char[] exp, int left, int right, int result, Map<String, Integer> cache) {
        String key = left + " " + right + " " + result;
        if(cache.containsKey(key)) {
            return cache.get(key);
        }

        if (left == right) {
            if (exp[left] - '0' == result) {
                return 1;
            } else {
                return 0;
            }
        }

        int total = 0;

        for (int i = left + 1; i <= right - 1; i += 2) {
            // TODO: may not need to calc all
            int left0 = numberOfWays(exp, left, i - 1, 0, cache);
            int left1 = numberOfWays(exp, left, i - 1, 1, cache);
            int right0 = numberOfWays(exp, i + 1, right, 0, cache);
            int right1 = numberOfWays(exp, i + 1, right, 1, cache);

            char operator = exp[i];

            if (operator == '&') {
                if (result == 1) {
                    total += left1 * right1;
                } else {
                    total += left0 * (right0 + right1) + (left0 + left1) * right0;
                }
            } else if (operator == '|') {
                if (result == 1) {
                    total += left1 * (right0 + right1) + (left0 + left1) * right1;
                } else {
                    total += left0 * right0;
                }
            } else if (operator == '^') {
                if (result == 1) {
                    total += left0 * right1 + left1 * right0;
                } else {
                    total += left0 * right0 + left1 * right1;
                }
            } else {
                // TODO: something is wrong
            }
        }

        cache.put(key, total);

        return total;
    }

}