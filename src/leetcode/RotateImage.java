package leetcode;

/**
 * Created by xzhang71 on 6/12/14.
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int length = matrix.length;

        for (int i = 0; i <= (length - 1) / 2; i++) {
            for (int j = i; j <= (length - 1) - i - 1; j++) {
                rotatePoints(matrix, i, j);
            }
        }
    }

    private void rotatePoints(int[][] matrix, int i, int j) {
        int l = matrix.length;
        int[][] points = {{i, j}, {j, l - i - 1}, {l - i - 1, l - j - 1}, {l - j - 1, i}};
        int temp = matrix[points[3][0]][points[3][1]];
        int k = 3;
        while (k >= 0) {
            matrix[points[k][0]][points[k][1]] = k == 0 ? temp : matrix[points[k - 1][0]][points[k - 1][1]];
            k--;
        }
    }
}
