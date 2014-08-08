package leetcode;

/**
 * Created by xzhang71 on 8/6/14.
 */
public class MedianOfTwoSortedArrays {

    public static double findMedianOfTwoSortedArrays(int[] A, int[] B) {
        int l = A.length + B.length;
        if (l % 2 == 0) {
            return 0.5 * (findKthOfTwoSortedArrays(A, B, l / 2 - 1) + findKthOfTwoSortedArrays(A, B, l / 2));
        } else {
            return findKthOfTwoSortedArrays(A, B, l / 2);
        }
    }

    public static int findKthOfTwoSortedArrays(int[] A, int[] B, int k) {
        return findKthOfTwoSortedArrays(A, 0, A.length - 1, B, 0, B.length - 1, k);
    }

    public static int findKthOfTwoSortedArrays(int[] A, int aleft, int aright, int[] B, int bleft, int bright, int k) {
        if (aleft > aright) {
            return B[bleft + k];
        }

        if (bleft > bright) {
            return A[aleft + k];
        }

        int amid = (aleft + aright) / 2;
        int bmid = (bleft + bright) / 2;

        int x = amid - aleft + 1 + bmid - bleft + 1;
        if (A[amid] < B[bmid]) {
            if (x <= k + 1) {
                return findKthOfTwoSortedArrays(A, amid + 1, aright, B, bleft, bright, k - (amid + 1 - aleft));
            } else {
                return findKthOfTwoSortedArrays(A, aleft, aright, B, bleft, bmid - 1, k);
            }
        } else {
            if (x <= k + 1) {
                return findKthOfTwoSortedArrays(A, aleft, aright, B, bmid + 1, bright, k - (bmid + 1 - bleft));
            } else {
                return findKthOfTwoSortedArrays(A, aleft, amid - 1, B, bleft, bright, k);
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7};
        int[] B = {2, 3, 4, 5, 6, 7, 8};
        System.out.println(MedianOfTwoSortedArrays.findMedianOfTwoSortedArrays(A, B));
    }
}