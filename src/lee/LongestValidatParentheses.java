package lee;

import java.util.Stack;

/**
 * Created by xzhang on 6/10/14.
 */
public class LongestValidatParentheses {

    // successive
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) return 0;

        int max = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    int last = stack.isEmpty() ? -1 : stack.peek();
                    max = Math.max(max, i - last);
                } else {
                    stack.push(i);
                }
            } else {
                // TODO: invalid character
            }
        }
        return max;
    }
}
