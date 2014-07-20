package cci;

/**
 * Created by xzhang71 on 7/17/14.
 */
public class BitDoubleToBinary {


    /**
     * Given a real number n (0 < n < 1), print the accurate binary representation within 32 characters, otherwise "ERROR"
     *
     * @param num
     */
    public static String doubleToBinary(double num) {
        StringBuilder cache = new StringBuilder(".");
        while (num != 0) {
            if (cache.length() >= 32) {
                return "ERROR";
            }

            num = num * 2;
            if (num >= 1) {
                cache.append(1);
                num = num - 1;
            } else {
                cache.append(0);
            }
        }
        return cache.toString();
    }

    public static void main(String[] args) {
        double num = 0.25;
        System.out.println(BitDoubleToBinary.doubleToBinary(num));
    }
}
