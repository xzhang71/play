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
            int j = i + 1;
            while (j < content.length() && content.charAt(j) == ch) {
                j++;
            }
            sb.append("" + ch + (j - i));
            i = j;
        }

        return sb.length() < content.length() ? sb.toString() : content;
    }

    public static void main(String[] args) {
        System.out.println(StringCompress.compress("abcde"));
        System.out.println(StringCompress.compress("aaabbbcccdddeee"));
    }
}
