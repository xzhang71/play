package cci;

/**
 * Created by xzhang71 on 7/17/14.
 */
public class BitNext {

    public static int nextSmallest(int n) {
        int zeros = 0;
        int ones = 0;
        int mask = 1;

        while ((zeros + ones <= 30) && (mask & n) == 0) {
            mask = mask << 1;
            zeros++;
        }

        while ((zeros + ones <= 30) && (mask & n) != 0) {
            mask = mask << 1;
            ones++;
        }

        if (zeros + ones >= 31) {
            System.out.print("invalid input.");
            return n;
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
        int zeros = 0;
        int ones = 0;
        int mask = 1;

        while ((zeros + ones) <= 30 && (n & mask) != 0) {
            ones++;
            mask = mask << 1;
        }

        while ((zeros + ones) <= 30 && (n & mask) == 0) {
            zeros++;
            mask = mask << 1;
        }

        if (zeros + ones >= 31) {
            System.out.print("invalid input.");
            return n;
        }

        n = n & (~mask);
        zeros--;
        mask = mask >> 1;

        while (ones > 0) {
            n = n | mask;
            ones--;
            mask = mask >> 1;
        }

        while (zeros > 0) {
            n = n & (~mask);
            zeros--;
            mask = mask >> 1;
        }

        return n;
    }

    public static void main(String[] args) {
        // 110011001100
        int n = 52428;
        // 110011010001 = 52433
        System.out.println(BitNext.nextSmallest(n));

        System.out.println(BitNext.nextSmallest(0));

        System.out.println(BitNext.nextSmallest(Integer.MAX_VALUE));

        // 1100110011
        n = 819;
        // 1100101110 = 814
        System.out.println(BitNext.nextLargest(n));

        System.out.println(BitNext.nextLargest(0));

        System.out.println(BitNext.nextLargest(Integer.MAX_VALUE));
    }
}
