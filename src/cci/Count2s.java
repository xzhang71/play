package cci;

/**
 * Created by xzhang71 on 7/26/14.
 */
public class Count2s {
    public static int count2s(int n) {
        // IMPORTANT
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return count2s(-(n + 1)) + 1;
            } else {
                return count2s(-n);
            }
        }

        int r = 0;
        int p = 1;
        while (n >= p) {
            int digit = n / p % 10;

            if (digit > 2) {
                r += digit * p / 10 + p;
            } else if (digit == 2) {
                r += digit * p / 10 + n % p + 1;
            } else {
                r += digit * p / 10;
            }

            // IMPORTANT
            if (Integer.MAX_VALUE / p < 10) {
                break;
            }
            p = p * 10;
        }

        return r;
    }

    public static int solution(int number) {
        int count = 0;
        int len = String.valueOf(number).length();
        for (int digit = 0; digit < len; digit++) {
            count += solutionGo(number, digit);
        }
        return count;
    }

    private static int solutionGo(int number, int d) {
        int powerOf10 = (int) Math.pow(10, d);
        int right = number % powerOf10;

        int digit = (number / powerOf10) % 10;
        int round = digit * powerOf10;
        if (digit < 2) {
            return round / 10;
        } else if (digit == 2) {
            return round / 10 + right + 1;
        } else {
            return round / 10 + powerOf10;
        }
    }

    public static void main(String[] args) {
        System.out.println(Count2s.count2s(Integer.MAX_VALUE)); // 373343123
        System.out.println(Count2s.solution(Integer.MAX_VALUE));
    }
}