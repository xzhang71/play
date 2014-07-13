package cci;

/**
 * Created by xzhang on 7/10/14.
 */
public class StringJoin {

    /**
     * Join words without any other data structure
     */

    public static String joinWords(String[] words) {
        return joinWords(words, 0, words.length - 1);
    }

    private static String joinWords(String[] words, int l, int r) {
        if (l == r) {
            return words[l];
        }

        int mid = (l + r) / 2;
        return joinWords(words, l, mid) + joinWords(words, mid + 1, r);
    }

    public static void main(String[] args) {
        System.out.println(joinWords(new String[]{"Join ", "words ", "without ", "any ", "other ", "data ", "structure"}));
    }
}
