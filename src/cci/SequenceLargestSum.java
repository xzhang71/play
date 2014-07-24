package cci;

/**
 * Created by xzhang71 on 7/23/14.
 */
public class SequenceLargestSum {

    public static int sequenceLargestSum(int[] A) {
        int max = 0;
        int maxToHere = 0;

        for (int i = 0; i < A.length; i++) {
            maxToHere = Math.max(maxToHere + A[i], A[i]);
            max = Math.max(max, maxToHere);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] A = {-3, -10, -5};
        System.out.println(SequenceLargestSum.sequenceLargestSum(A));
    }
}
