package cci;

/**
 * Created by xzhang71 on 7/18/14.
 */
public class MagicIndex {

    public static int findNoDup(int[] A) {
        return findNoDup(A, 0, A.length - 1);
    }

    private static int findNoDup(int[] A, int l, int r) {
        if (l > r) {
            return -1;
        }

        int mid = (l + r) / 2;

        if (A[mid] == mid) {
            return mid;
        } else if (A[mid] > mid) {
            return findNoDup(A, l, mid - 1);
        } else {
            return findNoDup(A, mid + 1, r);
        }
    }

    public static int findDup(int[] A) {
        return findDup(A, 0, A.length - 1);
    }

    private static int findDup(int[] A, int l, int r) {
        if (l > r) {
            return -1;
        }

        int mid = (l + r) / 2;

        if (A[mid] == mid) {
            return mid;
        }

        int left = findDup(A, l, Math.min(A[mid], mid - 1));
        if (left >= 0) {
            return left;
        }

        int right = findDup(A, Math.max(A[mid], mid + 1), r);
        if (right >= 0) {
            return right;
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] A = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        // 7
        System.out.println(MagicIndex.findNoDup(A));

        int[] B = {-10, -5, 2, 2, 2, 3, 5, 7, 9, 12, 13};
        // 2
        System.out.println(MagicIndex.findDup(B));
    }

}
