package Lee;

/**
 * Created by xzhang71 on 6/8/14.
 */
public class StringToIntegerATOI {

    public int atoi(String str) {
        // intput is null
        if (str == null) {
            return 0;
        }

        int index = 0;

        // escape all spaces in the front
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }

        boolean isNegative = false;

        if (index < str.length()) {
            if (str.charAt(index) == '+') {
                index++;
            } else if (str.charAt(index) == '-') {
                isNegative = true;
                index++;
            }
        }

        // put all valid characters into string buffer
        int result = 0;
        for (int i = index; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                break;
            }

            int t = c - '0';
            if (isNegative) {
                t = -t;
            }

            if (!isNegative && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && t > Integer.MAX_VALUE % 10))) {
                return Integer.MAX_VALUE;
            }

            if (isNegative && (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && t < Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            result = result * 10 + t;
        }

        return result;
    }
}
