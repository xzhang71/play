package cci;

/**
 * Created by xzhang71 on 7/20/14.
 */
public class SortedArrayMerge {

    public static void merge(int[] A, int ap, int[] B, int bp) {
        int k = ap + bp + 1;
        while (ap >= 0 && bp >= 0) {
            if (A[ap] > B[bp]) {
                A[k] = A[ap];
                ap--;
                k--;
            } else {
                A[k] = B[bp];
                bp--;
                k--;
            }
        }

        while (bp >= 0) {
            A[k] = A[bp];
            bp--;
            k--;
        }
    }

    public static void main(String[] args) {
        int[] A = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] B = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        SortedArrayMerge.merge(A, 9, B, 9);
        for (int i : A) {
            System.out.print(i + " ");
        }
    }
}
