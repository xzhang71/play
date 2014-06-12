package lee;

/**
 * Created by xzhang71 on 6/11/14.
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n < 0) {
            // TODO
        }

        String str = "1";
        if (n == 1) {
            return str;
        }

        StringBuilder sb1 = new StringBuilder(str);
        StringBuilder sb2 = new StringBuilder();
        while (n > 1) {
            StringBuilder temp = sb1;
            sb1 = sb2;
            sb2 = temp;
            sb1.delete(0, sb1.length());
            int i = 1, count = 1;
            while (i < sb2.length()) {
                if (sb2.charAt(i) == sb2.charAt(i - 1)) {
                    count++;
                } else {
                    // IMPORTANT
                    // the following is wrong, (int) + (char) converts int to char
                    // sb1.append(count + sb2.charAt(i - 1));
                    sb1.append(String.valueOf(count) + sb2.charAt(i - 1));
                    count = 1;
                }
                i++;
            }
            // IMPORTANT
            // the same as the previous one
            sb1.append(String.valueOf(count) + sb2.charAt(i - 1));
            n--;
        }
        return sb1.toString();
    }

}
