package cci;

/**
 * Created by xzhang on 7/10/14.
 */
public class RotateMatrix {

    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int r = 0; r < len / 2; r++) {
            for (int c = 0; c < len / 2; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[len - c - 1][r];
                matrix[len - c - 1][r] = matrix[len - r - 1][len - c - 1];
                matrix[len - r - 1][len - c - 1] = matrix[c][len - r - 1];
                matrix[c][len - r - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {4, 8, 12, 16},
                {3, 7, 11, 15},
                {2, 6, 10, 14},
                {1, 5, 9, 13}
        };
        RotateMatrix.rotate(matrix);
        int len = matrix.length;
        for (int r = 0; r < len; r++) {
            for (int c = 0; c < len; c++) {
                System.out.printf("%3s ", matrix[r][c]);
            }
            System.out.println();
        }
    }
}
