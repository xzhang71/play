package cci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xzhang71 on 7/20/14.
 */
public class ExpressionParentheses {

    public static List<String> generate(String exp, int val) {
        return generate(exp, val, new HashMap<String, List<String>>());
    }

    private static List<String> generate(String exp, int val, Map<String, List<String>> cache) {
        String key = exp + '_' + val;
        if (cache.containsKey(key)) {
            return new ArrayList<>(cache.get(key));
        }

        List<String> result = new ArrayList<>();
        if (exp.length() == 1) {
            if (exp.charAt(0) - '0' == val) {
                result.add(exp);
            }
            return result;
        }

        for (int i = 1; i < exp.length(); i += 2) {
            List<String> left0 = generate(exp.substring(0, i), 0, cache);
            List<String> left1 = generate(exp.substring(0, i), 1, cache);
            List<String> right0 = generate(exp.substring(i + 1, exp.length()), 0, cache);
            List<String> right1 = generate(exp.substring(i + 1, exp.length()), 1, cache);

            if (exp.charAt(i) == '^') {
                if (val == 0) {
                    result.addAll(innerJoin(left0, '^', right0));
                    result.addAll(innerJoin(left1, '^', right1));
                } else {
                    result.addAll(innerJoin(left0, '^', right1));
                    result.addAll(innerJoin(left1, '^', right0));
                }
            } else if (exp.charAt(i) == '&') {
                if (val == 0) {
                    result.addAll(innerJoin(left0, '&', right0));
                    result.addAll(innerJoin(left0, '&', right1));
                    result.addAll(innerJoin(left1, '&', right0));
                } else {
                    result.addAll(innerJoin(left1, '&', right1));
                }
            } else if (exp.charAt(i) == '|') {
                if (val == 0) {
                    result.addAll(innerJoin(left0, '|', right0));
                } else {
                    result.addAll(innerJoin(left0, '|', right1));
                    result.addAll(innerJoin(left1, '|', right1));
                    result.addAll(innerJoin(left1, '|', right1));
                }
            }
        }

        cache.put(key, new ArrayList<>(result));

        return result;
    }

    private static List<String> innerJoin(List<String> left, char operator, List<String> right) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String ls : left) {
            sb.delete(0, sb.length());

            if (ls.length() > 1) {
                sb.append('(');
                sb.append(ls);
                sb.append(')');
            } else {
                sb.append(ls);
            }
            sb.append(operator);

            for (String rs : right) {
                if (rs.length() > 1) {
                    sb.append('(');
                    sb.append(rs);
                    sb.append(')');
                } else {
                    sb.append(rs);
                }
                result.add(sb.toString());
                sb.delete(ls.length() + 1, sb.length());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String exp = "1^0|0|1";
        int val = 0;
        List<String> result = ExpressionParentheses.generate(exp, val);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
