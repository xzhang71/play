package cci;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhang71 on 7/19/14.
 */
public class ValidParentheses {

    public static List<String> generate(int n) {
        List<String> parentheses = new ArrayList<>();
        generate(n, n, parentheses, new StringBuilder());
        return parentheses;
    }

    private static void generate(int leftRem, int rightRem, List<String> cache, StringBuilder sb) {
        if (leftRem < 0 || rightRem < 0 || leftRem > rightRem) {
            return;
        }

        if (leftRem == 0 && rightRem == 0) {
            cache.add(sb.toString());
            return;
        }

        sb.append('(');
        generate(leftRem - 1, rightRem, cache, sb);
        sb.delete(sb.length() - 1, sb.length());

        sb.append(')');
        generate(leftRem, rightRem - 1, cache, sb);
        sb.delete(sb.length() - 1, sb.length());
    }

    public static void main(String[] args) {
        List<String> parentheses = ValidParentheses.generate(3);
        for (String s : parentheses) {
            System.out.println(s);
        }
    }
}
