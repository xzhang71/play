package lee;

/**
 * Created by xzhang71 on 6/8/14.
 */
public class ZigZagConversation {
    public static void main(String[] args) {
        String result3 = convert("ABCD", 4);
        System.out.println(result3);
    }

    public static String convert(String s, int nRows) {
        if (s == null || nRows <= 0) return "";
        if (nRows == 1) return s;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < nRows; i++) {
            if (i == 0 || i == nRows - 1) {
                int step = 2 * nRows - 2;
                for (int j = i; j < s.length(); j = j + step) {
                    sb.append(s.charAt(j));
                }
            } else {
                int step1 = 2 * i;
                int step2 = 2 * (nRows - 1 - i);
                for (int j = i; j < s.length(); j = j + step1) {
                    int temp = step1;
                    step1 = step2;
                    step2 = temp;
                    sb.append(s.charAt(j));
                }
            }
        }
        return sb.toString();
    }
}
