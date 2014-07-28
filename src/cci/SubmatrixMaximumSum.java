package cci;

/**
 * Created by xzhang71 on 7/28/14.
 */
public class SubmatrixMaximumSum {

    public static int maxSubMatrix(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int[] partialSum = new int[colCount];
        int maxSum = 0;
        for (int rowStart = 0; rowStart < rowCount; rowStart++) {
            clearArray(partialSum);
            for (int rowEnd = rowStart; rowEnd < rowCount; rowEnd++) {
                for (int i = 0; i < colCount; i++) {
                    partialSum[i] += matrix[rowEnd][i];
                }
                int tempMaxSum = maxSubarray(partialSum);
                maxSum = Math.max(maxSum, tempMaxSum);
            }
        }
        return maxSum;
    }

    public static void clearArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }

    public static int maxSubarray(int[] array) {
        int maxSum = 0;
        int runningSum = 0;
        for (int i = 0; i < array.length; i++) {
            runningSum = Math.max(runningSum + array[i], array[i]);
            maxSum = Math.max(maxSum, runningSum);
        }
        return maxSum;
    }
}