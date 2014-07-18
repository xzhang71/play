package cci;

/**
 * Created by xzhang71 on 7/18/14.
 */
public class Fibonacci {

    public static int fib(int n) {
        if (n < 0) {
            throw new RuntimeException("invalid input");
        }

        if (n <= 1) {
            return n;
        }

        int x = 0;
        int y = 1;

        for (int i = 2; i <= n; i++) {
            int z = x + y;
            x = y;
            y = z;
        }

        return y;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Fibonacci.fib(i));
        }
    }
}
