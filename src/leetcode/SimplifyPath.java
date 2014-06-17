package leetcode;

import java.util.Stack;

/**
 * Created by xzhang71 on 6/15/14.
 */
public class SimplifyPath {

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        String path = "/.";
        System.out.println(sp.simplifyPath(path));
    }

    public String simplifyPath(String path) {
        if (path == null) {
            // TODO: ERROR?
            return "";
        }

        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String str : paths) {
            if (str.equals("..")) {
                if (stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!str.equals("") && !str.equals(".")) {
                stack.push(str);
            }
        }

        String[] tempArr = new String[stack.size()];
        int i = tempArr.length - 1;
        while (!stack.isEmpty()) {
            tempArr[i] = stack.pop();
            i--;
        }

        StringBuilder sb = new StringBuilder("");
        for (String str : tempArr) {
            sb.append("/");
            sb.append(str);
        }
        // if string arr is empty
        if (sb.length() == 0) {
            sb.append("/");
        }

        return sb.toString();
    }
}
