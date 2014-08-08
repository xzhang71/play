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
        long r = 0;
        while (x != 0) {
            r = r * 10 + x % 10;
            x = x / 10;
        }
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
            // do something
        }
        return (int) r;
    }
}