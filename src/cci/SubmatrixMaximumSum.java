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
        for (int startRow = 0; startRow < rowCount; startRow++) {
            clearArray(partialSum);
            for (int endRow = startRow; endRow < rowCount; endRow++) {
                for (int col = 0; col < colCount; col++) {
                    partialSum[col] += matrix[endRow][col];
                }
                int tempMaxSum = getMaxSum(partialSum);
                maxSum = Math.max(maxSum, tempMaxSum);
            }
        }
        return maxSum;
    }

    public static void clearArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = 0;
        }
    }

    public static int getMaxSum(int[] A) {
        int maxSum = 0;
        int runningSum = 0;
        for (int i = 0; i < A.length; i++) {
            runningSum = Math.max(runningSum + A[i], A[i]);
            maxSum = Math.max(maxSum, runningSum);
        }
        return maxSum;
    }
}