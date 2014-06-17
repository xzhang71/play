package leetcode;

/**
 * Created by xzhang71 on 6/8/14.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int result4 = reverse(-1234);
        System.out.println(result4);
    }

    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            // do something
        }
        return (int) result;
    }
}
