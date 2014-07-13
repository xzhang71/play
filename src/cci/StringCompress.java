package cci;

/**
 * Created by xzhang on 7/10/14.
 */
public class StringCompress {

    public static String compress(String content) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < content.length()) {
            char ch = content.charAt(i);
            int l = 1;
            i++;
            while (i < content.length() && content.charAt(i) == ch) {
                l++;
                i++;
            }
            sb.append("" + ch + l);
        }

        return sb.length() < content.length() ? sb.toString() : content;
    }

    public static void main(String[] args) {
        System.out.println(StringCompress.compress("abcde"));
        System.out.println(StringCompress.compress("aaabbbcccdddeee"));
    }
}
