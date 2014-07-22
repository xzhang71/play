package cci;

/**
 * Created by xzhang71 on 7/17/14.
 */
public class BitSwapOddEven {

    public static int swap(int n) {
        return ((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1);
    }

    public static void main(String[] args) {
        int n = 0x80005555; // 0101 0101 0101 0101
        System.out.println(BitSwapOddEven.swap(n) == 0x4000AAAA);
    }
}
