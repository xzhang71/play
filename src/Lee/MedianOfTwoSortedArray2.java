package Lee;

/**
 * Created by xzhang71 on 6/8/14.
 */
public class MedianOfTwoSortedArray2 {
    public static void main(String[] args) {
        int[] A = {3};
        int[] B = {1, 2, 4, 5, 6};

        double result2 = findMedian2(A, B);
        System.out.println(result2);
    }


    public static double findMedian2(int[] A, int[] B) {
        if (A == null || B == null) {
            return -1;
        }
        int l = A.length + B.length;
        if (l % 2 == 0) {
            return (findKth2(A, B, l / 2) + findKth2(A, B, l / 2 + 1)) * 0.5;
        } else {
            return (double) findKth2(A, B, l / 2 + 1);
        }
    }

    // eg.
    // A = {1,3,5,7,9}
    // B = {2,4,6,8}
    public static int findKth2(int[] A, int[] B, int k) {
        if (A == null || B == null || k <= 0 || (A.length + B.length) < k) {
            return -1;
        }
        return go2(A, 0, A.length - 1, B, 0, B.length - 1, k);
    }

    public static int go2(int[] A, int aleft, int aright, int[] B, int bleft, int bright, int k) {
        int alength = aright - aleft + 1;
        int blength = bright - bleft + 1;
        int i = (int) (1.0 * alength / (alength + blength) * (k - 1));
        // k + 1= (i + 1) + (j + 1)
        // Bj_1 < Ai < Bj
        int j = k - 1 - i;
        int Ai_1 = i == 0 ? Integer.MIN_VALUE : A[i - 1];
        int Ai = i == A.length ? Integer.MAX_VALUE : A[i];
        int Bj_1 = j == 0 ? Integer.MIN_VALUE : B[j - 1];
        int Bj = j == B.length ? Integer.MAX_VALUE : B[j];

        if (Bj_1 <= Ai && Ai <= Bj) {
            return Ai;
        }
        if (Ai_1 <= Bj && Bj <= Ai) {
            return Bj;
        }

        if (Ai < Bj) {
            return go2(A, i + 1, aright, B, bleft, j - 1, k - (i + 1 - aleft + 1));
        } else {
            return go2(A, aleft, i - 1, B, j + 1, bright, k - (j + 1 - bleft + 1));
        }
    }
}
