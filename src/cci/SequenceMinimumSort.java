package cci;

import java.util.Arrays;

/**
 * Created by xzhang71 on 7/23/14.
 */
public class SequenceMinimumSort {

    public static int[] sequenceMinimumSort(int[] A) {
        int left = A.length - 1;
        int min = A[left];
        for (int i = A.length - 1; i >= 0; i--) {
            if (min >= A[i]) {
                min = A[i];
            } else {
                left = i;
            }
        }

        int right = 0;
        int max = A[right];
        for (int i = 0; i < A.length - 1; i++) {
            if (max <= A[i]) {
                max = A[i];
            } else {
                right = i;
            }
        }

        if (left >= right) {
            return new int[]{0, 0};
        } else {
            return new int[]{left, right};
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        int[] r = SequenceMinimumSort.sequenceMinimumSort(A);
        // 3, 9
        System.out.printf("{%d, %d}\n", r[0], r[1]);

        Arrays.sort(A);
        r = SequenceMinimumSort.sequenceMinimumSort(A);
        // 0, 0
        System.out.printf("{%d, %d}\n", r[0], r[1]);
    }
}
