package cci;

/**
 * Created by xzhang71 on 7/19/14.
 */
public class NCents {
    public static int numOfWays(int sum, int[][] coins) {
        // significant optimization
        int[][] cache = new int[sum + 1][coins.length];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                cache[i][j] = -1;
            }
        }
        return numOfWays(sum, coins, coins.length - 1, cache);
    }

    private static int numOfWays(int sum, int[][] coins, int index, int[][] cache) {
        if (sum == 0) {
            return 1;
        }

        if (index < 0) {
            return 0;
        }

        if (cache[sum][index] >= 0) {
            return cache[sum][index];
        }

        int numOfWays = 0;
        for (int i = 0; i <= coins[index][1]; i++) {
            int remaining = sum - coins[index][0] * i;
            if (remaining < 0) {
                break;
            }
            numOfWays += numOfWays(remaining, coins, index - 1, cache);
        }

        cache[sum][index] = numOfWays;
        return numOfWays;
    }

    public static void main(String[] args) {
        int[][] coins = {
                // value + num of coins
                {1, 213},
                {5, 213},
                {10, 213},
                {25, 213}
        };
        // 99 -> 213
        System.out.println(NCents.numOfWays(99, coins));

        int[][] coins2 = {
                // value + num of coins
                {1, 3},
                {5, 2},
                {10, 1},
                {25, 3}
        };
        // 99 -> 0
        System.out.println(NCents.numOfWays(99, coins2));

        int[][] coins3 = {
                // value + num of coins
                {1, 4},
                {5, 2},
                {10, 2},
                {25, 3}
        };
        // 99 -> 2
        System.out.println(NCents.numOfWays(99, coins3));
    }
}
