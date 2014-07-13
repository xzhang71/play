package cci.temp;

/**
 * Created by xzhang on 6/24/14.
 */
public class SearchMatrix {

    public static void main(String[] args) {
        SearchMatrix obj = new SearchMatrix();

        int[][] matrix = {
                {10, 25, 70, 75},
                {20, 35, 80, 85},
                {30, 45, 90, 95},
                {40, 55, 100, 105}
        };

//        for (int x = 0; x < matrix.length; x++) {
//            for (int y = 0; y < matrix[x].length; y++) {
//                int[] result = obj.searchMatrix(matrix, matrix[x][y]);
//                System.out.printf("[%d, %d]", result[0], result[1]);
//            }
//            System.out.println();
//        }

        int[] result = obj.searchMatrix(matrix, 10);
        System.out.printf("[%d, %d]", result[0], result[1]);
        System.out.println();
    }

    private int[] searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }

        int x0 = 0, y0 = 0, x1 = matrix.length - 1, y1 = matrix[0].length - 1;
        return searchMatrixGo(matrix, target, x0, y0, x1, y1);
    }

    private int[] searchMatrixGo(int[][] matrix, int target, int x0, int y0, int x1, int y1) {
        if (x0 == x1) {
            return searchHorizontal(matrix, target, x0, y0, y1);
        }

        if (y0 == y1) {
            return searchVertical(matrix, target, x0, x1, y0);
        }

        int cx0 = x0;
        int cx1 = x1;
        int cy0 = y0;
        int cy1 = y1;

        while (cx0 <= cx1 && cy0 <= cy1) {
            if (cx0 == cx1 && cy0 == cy1) {
                if (matrix[cx0][cy0] == target) {
                    return new int[]{cx0, cy0};
                } else if (matrix[cx0][cy0] >= target) {
                    int[] downleft = searchMatrixGo(matrix, target, cx0, y0, x1, cy0 - 1);
                    if (downleft != null) {
                        return downleft;
                    }

                    int[] upright = searchMatrixGo(matrix, target, x0, cy0, cx0 - 1, y1);
                    if (upright != null) {
                        return upright;
                    }

                    return null;
                    // return new int[]{cx0, cy0};
                } else {
                    return null;
                }
            }

            int xmid = (cx0 + cx1) / 2;
            int ymid = (cy0 + cy1) / 2;

            // first greater than or equal to
            if (matrix[xmid][ymid] >= target) {
                cx1 = xmid;
                cy1 = ymid;
            } else {
                cx0 = xmid + 1;
                cy0 = ymid + 1;
            }
        }

        return null;
    }

    private int[] searchHorizontal(int[][] matrix, int target, int x, int y0, int y1) {
        // TODO: linear search to binary search
        for (int i = y0; i <= y1; i++) {
            if (target == matrix[x][i]) {
                int[] r = new int[2];
                r[0] = x;
                r[1] = i;
                return r;
            }
        }
        return null;
    }

    private int[] searchVertical(int[][] matrix, int target, int x0, int x1, int y) {
        // TODO: linear search to binary search
        for (int i = x0; i <= x1; i++) {
            if (target == matrix[i][y]) {
                int[] r = new int[2];
                r[0] = i;
                r[1] = y;
                return r;
            }
        }
        return null;
    }
}
