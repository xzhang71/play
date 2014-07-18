package cci;

/**
 * Created by xzhang71 on 7/17/14.
 */
public class BitFlipToEqual {

    public static int numOfFlips(int a, int b) {
        int diff = a ^ b;

        int numOfFlips = 0;
        while (diff != 0) {
            numOfFlips += diff & 1;
            diff >>= 1;
        }

        return numOfFlips;
    }

    public static void main(String[] args) {
        int a = 29; // 11101
        int b = 15; // 01111
        System.out.println(BitFlipToEqual.numOfFlips(a, b)); // 2
    }
}
