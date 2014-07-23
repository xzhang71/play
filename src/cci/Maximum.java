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

        int signab = signa ^ signb; // if(same) 0, different 1

        int sign = (signab ^ 1) * signc + signab * signa; // if(same) signc, else signa

        return (sign ^ 1) * a + sign * b;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int a = rand.nextInt(), b = rand.nextInt();
            int r1 = Maximum.max(a, b);
            int r2 = Math.max(a, b);
            System.out.printf("Maximum of %d and %d is %d, %s\n", a, b, r1, r1 == r2);
        }
    }
}