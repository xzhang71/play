package Lee;

/**
 * Created by xzhang71 on 6/8/14.
 */
public class MedianOfTwoSortedArray {

    public static void main(String[] args) {
        int[] A = {3};
        int[] B = {1, 2, 4, 5, 6};

        double result = findMedian(A, B);
        System.out.println(result);
    }

    public static double findMedian(int[] A, int[] B) {
        if (A == null || B == null) {
            return -1;
        }
        int l = A.length + B.length;
        if (l % 2 == 0) {
            return (findKth(A, B, l / 2) + findKth(A, B, l / 2 + 1)) * 0.5;
        } else {
            return (double) findKth(A, B, l / 2 + 1);
        }
    }

    public static int findKth(int[] A, int[] B, int k) {
        if (A == null || B == null || k <= 0 || (A.length + B.length) < k) {
            return -1;
        }
        return go(A, 0, A.length - 1, B, 0, B.length - 1, k);
    }

    public static int go(int[] A, int aleft, int aright, int[] B, int bleft, int bright, int k) {
        if (aleft > aright) return B[k - 1];
        if (bleft > bright) return A[k - 1];

        if (k <= 1) return Math.min(A[aleft], B[bleft]);

        int amid = (aleft + aright) / 2;
        int bmid = (bright + bright) / 2;


        if (A[amid] >= B[bmid]) {
            if ((amid - aleft + 1) + (bmid - bleft + 1) >= k + 1) {
                // why k + 1?
                // while truncate A, you don't want to keep A[amid] to the next recursion call because it causes complex code afterwards
                // this k + 1 helps get rid of A[amid] and move the pivot one position away from amid to amid - 1
                // the pivot amid will be kept while truncate B
                // while truncate B, you don't care about A[amid] and therefore it is safe to keep it
                // the conclusion is to avoid the situations that you truncate one data structure and keep the pivot intact

                // kth number won't be in the second half of A, won't be A[amid] either
                return go(A, aleft, amid - 1, B, bleft, bright, k);
            } else {
                // kth number won't be in the first half of B, and B[bmid] cannot be the kth number either
                return go(A, aleft, aright, B, bmid + 1, bright, k - (bmid - bleft + 1));
            }
        } else {
            if ((amid - aleft + 1) + (bmid - bleft + 1) >= k + 1) {
                // kth number won't be in the second half of B, but B[amid] might be the kth number
                return go(A, aleft, aright, B, bleft, bmid - 1, k);
            } else {
                // kth number won't be in the first half of A, and A[bmid] cannot be the kth number
                return go(A, amid + 1, aright, B, bleft, bright, k - (amid - aleft + 1));
            }
        }
    }

}
