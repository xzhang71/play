package cci;

/**
 * Created by xzhang71 on 7/17/14.
 */
public class MathAddOnly {

    public static int multiply(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        int r = 0;
        for (int i = 0; i <= 31; i++) {
            if (((1 << i) & b) != 0) {
                r += a << i;
            }
        }

        r = r | ((a & 0x80000000) ^ (a & 0x80000000));
        return r;
    }

    // IMPORTANT
    public static int subtract(int a, int b) {
        return a + (~b + 1);
    }

    // IMPORTANT
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("divided by 0");
        }

        int sign = 0x80000000 & (a ^ b);
        if (a < 0) {
            a = ~a + 1;
        }
        if (b < 0) {
            b = ~b + 1;
        }

        int p = 0;
        while ((a >> 1) >= b) {
            b = b << 1;
            p++;
        }

        int t = 0;
        int r = 0;
        while (p >= 0) {
            if (a >= t + b) {
                r += 1 << p;
                t = t + b;
            }
            p--;
            b = b >> 1;
        }

        if (sign != 0) {
            return ~r + 1;
        }
        return r;
    }

    public static void main(String[] args) {
        // -12321
        System.out.println(MathAddOnly.multiply(111, -111));
        System.out.println(111 * (-111));
        // -2147483648
        System.out.println(MathAddOnly.multiply(Integer.MIN_VALUE, 1));
        System.out.println(Integer.MIN_VALUE * 1);

        System.out.println();

        // 222
        System.out.println(MathAddOnly.subtract(111, -111));
        System.out.println(111 - (-111));
        // -2147483647
        System.out.println(MathAddOnly.subtract(Integer.MIN_VALUE, -1));
        System.out.println(Integer.MIN_VALUE - (-1));

        System.out.println();

        // 222
        System.out.println(MathAddOnly.divide(111, -111));
        System.out.println(111 / (-111));
        // -2147483647
        System.out.println(MathAddOnly.divide(Integer.MAX_VALUE, -1));
        System.out.println(Integer.MAX_VALUE / (-1));
    }
}
