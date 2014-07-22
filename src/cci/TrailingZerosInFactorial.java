package cci;

/**
 * Created by xzhang71 on 7/21/14.
 */
public class TrailingZerosInFactorial {
    public static int numOfZeros(int n) {
        if (n < 0) {
            return -1;
        }

        int num = 0;
        for (int i = 5; i <= n; i += 5) {
            int j = i;
            while (j > 0 && j % 5 == 0) {
                num++;
                j = j / 5;
            }
        }
        return num;
    }

    public static int numOfZerosImproved(int n) {
        if (n < 0) {
            return -1;
        }

        int num = 0;
        for (int i = 5; i <= n; i *= 5) {
            num += n / i;
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(TrailingZerosInFactorial.numOfZeros(100));

        System.out.println(TrailingZerosInFactorial.numOfZerosImproved(100));
    }
}
