package leetcode;

import java.util.Stack;

/**
 * Created by xzhang71 on 6/16/14.
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        char[][] matrix = {{'0'}};
        MaximalRectangle obj = new MaximalRectangle();
        int result = obj.maximalRectangle(matrix);
        System.out.println(result);
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int max = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    height[j] = 0;
                } else {
                    height[j] += 1;
                }
            }
            max = Math.max(largestRectangleArea(height), max);
        }

        return max;
    }

    private int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int i = 0;

        while (i < height.length) {
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.add(i);
                i++;
            } else {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
        }

        while (!stack.isEmpty()) {
            int h = height[stack.pop()];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(max, h * w);
        }

        return max;
    }
}
