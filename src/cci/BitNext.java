package cci;

/**
 * Created by xzhang71 on 7/17/14.
 */
public class BitNext {

    public static int nextSmallest(int n) {
        if (n == Integer.MAX_VALUE) {
            throw new RuntimeException("next smallest does not exist");
        }

        int zeros = 0;
        int ones = 0;
        int mask = 1;

        while ((mask & n) == 0) {
            mask = mask << 1;
            zeros++;
        }

        while ((mask & n) != 0) {
            mask = mask << 1;
            ones++;
        }

        n = n | mask;
        ones--;
        zeros++;
        mask = mask >> 1;

        while (zeros > 0) {
            n = n & (~mask);
            zeros--;
            mask = mask >> 1;
        }

        while (ones > 0) {
            n = n | mask;
            ones--;
            mask = mask >> 1;
        }

        return n;
    }

    public static int nextLargest(int n) {
        if (n == 0) {
            throw new RuntimeException("next largest does not exist");
        }

        int zeros = 0;
        int ones = 0;
        int mask = 1;

        while ((n & mask) != 0) {
            ones++;
            mask <<= 1;
        }

        while ((n & mask) == 0) {
            zeros++;
            mask <<= 1;
        }

        n = n & (~mask);
        zeros--;
        ones++;
        mask >>= 1;

        while (ones > 0) {
            n = n | mask;
            ones--;
            mask >>= 1;
        }

        while (zeros > 0) {
            n = n & (~mask);
            zeros--;
            mask >>= 1;
        }

        return n;
    }

    public static void main(String[] args) {
        // 110011001100
        int n = 52428;
        // 110011010001 = 52433
        System.out.println(BitNext.nextSmallest(n));

        // 1100110011
        n = 819;
        // 1100101110 = 814
        System.out.println(BitNext.nextLargest(n));
    }
}
