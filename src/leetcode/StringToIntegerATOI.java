package leetcode;

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

        if (index == str.length()) {
            return 0;
        }

        boolean isPos = true;
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            index++;
            isPos = false;
        }

        int result = 0;
        while (index < str.length()) {
            char c = str.charAt(index);
            if (c < '0' || c > '9') {
                break;
            }

            int t;
            if (isPos) {
                t = c - '0';
            } else {
                t = '0' - c;
            }

            if (isPos && result > (Integer.MAX_VALUE - t) / 10) {
                return Integer.MAX_VALUE;
            }

            if (!isPos && result < (Integer.MIN_VALUE - t) / 10) {
                return Integer.MIN_VALUE;
            }

            result = result * 10 + t;
            index++;
        }

        return result;
    }
}