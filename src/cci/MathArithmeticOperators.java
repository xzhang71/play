package cci;

import java.util.Random;

/**
 * Created by xzhang71 on 7/25/14.
 */
public class MathArithmeticOperators {
    public static int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        return add(a ^ b, (a & b) << 1);
    }

    public static int subtract(int a, int b) {
        return add(a, ~b + 1);
    }

    public static int multiply(int a, int b) {
        boolean isPos = true;
        int r = 0;
        if (a < 0) {
            // IMPORTANT
            if (a == Integer.MIN_VALUE) {
                r += Math.abs(b);
                a++;
            }
            isPos = !isPos;
            a = ~a + 1;
        }
        if (b < 0) {
            // IMPORTANT
            if (b == Integer.MIN_VALUE) {
                r += Math.abs(a);
                b++;
            }
            isPos = !isPos;
            b = ~b + 1;
        }

        /*
        while (b != 0) {
            if ((b & 1) != 0) {
                r += a;
            }
            a = a << 1;
            b = b >> 1;
        }
        */
        r += multiplyGo(a, b);

        if (isPos) {
            return r;
        } else {
            return ~r + 1;
        }
    }

    private static int multiplyGo(int a, int b) {
        if (b == 0) {
            return 0;
        }
        return (b & 1) * a + multiplyGo(a << 1, b >> 1);
    }

    public static int divide(int a, int b) {
        // IMPORTANT
        if (b == 0) {
            throw new ArithmeticException("divided by 0");
        }
        // IMPORTANT
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        }
        int r = 0;
        boolean isPos = true;
        if (b < 0) {
            isPos = !isPos;
            b = ~b + 1;
        }
        if (a < 0) {
            // IMPORTANT
            if (a == Integer.MIN_VALUE) {
                a = a + b;
                r++;
            }
            isPos = !isPos;
            a = ~a + 1;
        }
        int p = 1;
        while ((a >> 1) >= b) {
            b = b << 1;
            p = p << 1;
        }

        /*
        int s = 0;
        while (p != 0) {
            if (a - s >= b) {
                r += p;
                s += b;
            }
            p = p >> 1;
            b = b >> 1;
        }
        */
        r += divideGo(a, b, p);

        if (isPos) {
            return r;
        } else {
            return ~r + 1;
        }
    }

    private static int divideGo(int a, int b, int p) {
        if (p == 0) {
            return 0;
        }
        int r = 0;
        if (a >= b) {
            r += p;
            a = a - b;
        }
        return r + divideGo(a, b >> 1, p >> 1);
    }

    public static void main(String[] args) {
        Random rand = new Random();

        boolean testAdd = true;
        for (int i = 0; i < 100; i++) {
            int a = rand.nextInt();
            int b = rand.nextInt();
            int r = add(a, b);
            int rr = a + b;
            if (r != rr) {
                testAdd = false;
            }
        }
        System.out.println("test add passed : " + testAdd);

        boolean testSubstract = true;
        for (int i = 0; i < 100; i++) {
            int a = rand.nextInt();
            int b = rand.nextInt();
            int r = subtract(a, b);
            int rr = a - b;
            if (r != rr) {
                testSubstract = false;
            }
        }
        System.out.println("test subtract passed : " + testSubstract);


        boolean testMultiply = true;
        for (int i = 0; i < 100; i++) {
            int a = rand.nextInt();
            int b = rand.nextInt();
            int r = multiply(a, b);
            int rr = a * b;
            if (r != rr) {
                testMultiply = false;
            }
        }
        System.out.println("test multiply passed : " + testMultiply);
        int x = Integer.MIN_VALUE * Integer.MIN_VALUE;
        int y = multiply(Integer.MIN_VALUE, Integer.MIN_VALUE);
        System.out.println("test mutiply Integer.MIN_VALUE, Integer.MIN_VAULE passed : " + (x == y));


        boolean testDivide = true;
        for (int i = 0; i < 100; i++) {
            int a = rand.nextInt();
            int b = rand.nextInt();
            int r = divide(a, b);
            int rr = a / b;
            if (r != rr) {
                testDivide = false;
            }
        }
        System.out.println("test divide passed : " + testDivide);
        x = Integer.MIN_VALUE / Integer.MIN_VALUE;
        y = divide(Integer.MIN_VALUE, Integer.MIN_VALUE);
        System.out.println("test divide Integer.MIN_VALUE, Integer.MIN_VAULE passed : " + (x == y));
    }
}