package cci;

/**
 * Created by xzhang71 on 7/17/14.
 */
public class BitFlipToEqual {

    public static int numOfFlips(int a, int b) {
        int diff = a ^ b;

        int numOfFlips = 0;
        int i = 1;
        while (i != 0) {
            if ((diff & i) != 0) {
                numOfFlips++;
            }
            i = i << 1;
        }

        return numOfFlips;
    }

    public static void main(String[] args) {
        int a = 0x0000000C;  // 0...1100
        int b = 0x80000003;  // 1...0011
        System.out.println(BitFlipToEqual.numOfFlips(a, b)); // 5
    }
}
