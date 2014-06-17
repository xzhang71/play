package leetcode;

import java.util.Stack;

/**
 * Created by xzhang71 on 6/16/14.
 */
public class LargestRectangleArea {

    public static void main(String[] args) {
        int[] height = {1};
        LargestRectangleArea obj = new LargestRectangleArea();
        int result = obj.largestRectangleArea(height);
        System.out.println(result);
    }

    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int i = 0;

        while(i < height.length) {
            if(stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.add(i);
                i++;
            } else {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
        }

        while(!stack.isEmpty()) {
            int h = height[stack.pop()];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(max, h * w);
        }

        return max;
    }
}
