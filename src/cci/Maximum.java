package cci;

import java.util.Random;

/**
 * Created by xzhang71 on 7/21/14.
 */
public class Maximum {
    /**
     * Find the max of two numbers without if-else or comparison operators
     *
     * @param a
     * @param b
     * @return
     */
    public static int max(int a, int b) {
        int c = a - b;

        int signa = a >>> 31;
        int signb = b >>> 31;
        int signc = c >>> 31;

        int signab = signa ^ signb; // same -> 0 otherwise -> 1
        int sign = signc * (1 ^ signab) + signa * signab;

        return a * (1 ^ sign) + b * sign;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int a = rand.nextInt(), b = rand.nextInt();
            int r1 = Maximum.max(a, b);
            int r2 = Math.max(a, b);
            System.out.printf("Maximum of %d and %d is %d, %s\n", a, b, r1, r1 == r2);
        }

        System.out.println(0x7fffffff);
        System.out.println(-1 >>> 1);
    }
}