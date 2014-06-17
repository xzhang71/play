package leetcode;

/**
 * Created by xzhang71 on 6/10/14.
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        int result = divide(2147483647, 1);
        System.out.println(result);
    }

    public static int divide(int dividend, int divisor) {
        if(divisor == 0) {
            // TODO: ERROR
        }

        boolean isPositive = true;
        if(divisor == Integer.MIN_VALUE) {
            if(dividend == Integer.MIN_VALUE) {
                // both min values
                return 1;
            } else {
                return 0;
            }
        }

        int result = 0;

        if(divisor < 0) {
            isPositive = !isPositive;
            divisor = -divisor;
        }

        if(dividend == Integer.MIN_VALUE) {
            dividend = dividend + divisor;
            result++;
        }

        if(dividend < 0) {
            dividend = -dividend;
            isPositive = !isPositive;
        }

        int digits = 0;
        // the following code does not work because if dividend is large enough, divisor << 1 may overflow and the loop never ends
        // while((divisor << 1) < dividend) {
        while(divisor <= dividend >> 1) {
            divisor = divisor << 1;
            digits++;
        }

        while(digits >= 0) {
            int diff = dividend - divisor;
            if(diff >= 0) {
                result = result + (1 << digits);
                dividend = diff;
            }
            divisor = divisor >> 1;
            digits--;
        }

        return isPositive ? result : -result;
    }
}
