package cci;

/**
 * Created by xzhang71 on 7/17/14.
 */
public class BitsInsert {

    /**
     * Given two 32-bit integers n and m, insert m into n between its position i and j, assuming length of m is j - i + 1
     *
     * @param bits
     * @param num
     * @param start
     * @param end
     * @return
     */
    public static int insert(int bits, int num, int start, int end) {
        int mask = (1 << (start + 1) - 1) | (~0 << (end + 1));
        return (mask & num) | (bits << start);
    }

    public static void main(String[] args) {
        int num = 512;
        int bits = 19;
        int start = 2;
        int end = 6;
        // 588
        System.out.println(BitsInsert.insert(bits, num, start, end));
    }
}
