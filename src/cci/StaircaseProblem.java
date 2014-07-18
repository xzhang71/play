package cci;

/**
 * Created by xzhang71 on 7/18/14.
 */
public class StaircaseProblem {

    public static int solve(int n) {
        if (n < 0) {
            return 0;
        }

        int[] cache = new int[3];
        cache[0] = 1;
        cache[1] = 1;
        cache[2] = 2;

        if (n < cache.length) {
            return cache[n];
        }

        for (int i = 3; i <= n; i++) {
            int t = cache[0] + cache[1] + cache[2];
            cache[0] = cache[1];
            cache[1] = cache[2];
            cache[2] = t;
        }

        return cache[2];
    }

    public static int solve2(int n) {
        return solve2Go(n, new int[n + 1]);
    }

    private static int solve2Go(int n, int[] cache) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (cache[n] > 0) {
            return cache[n];
        } else {
            cache[n] = solve2Go(n - 1, cache) + solve2Go(n - 2, cache) + solve2Go(n - 3, cache);
            return cache[n];
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.printf("%dth: solve %d, solve2 %d\n", i, StaircaseProblem.solve(i), StaircaseProblem.solve2(i));
        }
    }
}
