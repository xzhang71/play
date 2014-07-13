package cci.temp;

/**
 * Created by xzhang on 7/10/14.
 */
public class MatrixRowColumnToZero {

    public static void paint(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int r0 = -1, c0 = -1;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    if (r0 == -1) {
                        r0 = r;
                        c0 = c;
                    } else {
                        matrix[r0][c] = 0;
                        matrix[r][c0] = 0;
                    }
                }
            }
        }

        for (int r = 0; r < matrix.length; r++) {
            if (r != r0 && matrix[r][c0] == 0) {
                for (int c = 0; c < matrix[r0].length; c++) {
                    matrix[r][c] = 0;
                }
            }
        }

        for (int c = 0; c < matrix[r0].length; c++) {
            if (c != c0 && matrix[r0][c] == 0) {
                for (int r = 0; r < matrix.length; r++) {
                    matrix[r][c] = 0;
                }
            }
        }

        for (int r = 0; r < matrix.length; r++) {
            matrix[r][c0] = 0;
        }

        for (int c = 0; c < matrix[r0].length; c++) {
            matrix[r0][c] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 1, 1}
        };
        MatrixRowColumnToZero.paint(matrix);
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.printf("%3d ", matrix[r][c]);
            }
            System.out.println();
        }
    }

}
