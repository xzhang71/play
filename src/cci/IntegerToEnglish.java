package cci;

/**
 * Created by xzhang71 on 7/23/14.
 */
public class IntegerToEnglish {

    private static final String[] digits = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] teens = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] bigs = {"", "Thousand", "Million", "Billion"};

    public static String integerToEnglish(int n) {
        if (n == 0) {
            return "Zero";
        } else if (n < 0) {
            return "Negative " + integerToEnglish(-n);
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            if (n % 1000 != 0) {
                sb.insert(0, integerToEnglish100(n % 1000) + bigs[count] + " ");
                n = n / 1000;
                count++;
            }
        }

        return sb.toString();
    }

    public static String integerToEnglish100(int n) {
        StringBuilder sb = new StringBuilder();

        if (n >= 100) {
            sb.append(digits[n / 100 - 1] + " Hundred ");
            n = n % 100;
        }

        if (n >= 11 && n <= 19) {
            sb.append(teens[n - 11] + " ");
            return sb.toString();
        } else if (n == 10 || n >= 20) {
            sb.append(tens[n / 10 - 1] + " ");
            n = n % 10;
        }

        if (n >= 1 && n <= 9) {
            sb.append(digits[n - 1] + " ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i > 0; i *= 3) {
            System.out.printf("%10d -> %s\n", i, IntegerToEnglish.integerToEnglish(i));
        }
    }
}
