package leetcode;

/**
 * Created by xzhang71 on 6/14/14.
 */

// TODO: FIND THE BUG

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            // TODO: ERROR?
            return 0;
        }

        int[] result = new int[m];
        result[0] = 1;

        for (int ni = 1; ni < n; ni++) {
            for (int mi = 1; mi < m; mi++) {
                result[mi] = result[mi - 1] + result[mi];
            }
        }

        return result[result.length - 1];
    }

}
