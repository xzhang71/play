package cci;

/**
 * Created by xzhang71 on 7/18/14.
 */
public class MagicIndex {

    public static int findWithoutDups(int[] A) {
        return findWithoutDups(A, 0, A.length - 1);
    }

    private static int findWithoutDups(int[] A, int l, int r) {
        if (l > r) {
            return -1;
        }

        int mid = (l + r) / 2;

        if (A[mid] == mid) {
            return mid;
        } else if (A[mid] > mid) {
            return findWithoutDups(A, l, mid - 1);
        } else {
            return findWithoutDups(A, mid + 1, r);
        }
    }

    public static int findWithDups(int[] A) {
        return findWithDups(A, 0, A.length - 1);
    }

    private static int findWithDups(int[] A, int l, int r) {
        if (l > r) {
            return -1;
        }

        int mid = (l + r) / 2;

        if (A[mid] == mid) {
            return mid;
        }

        int left = findWithDups(A, l, Math.min(A[mid], mid - 1));
        if (left >= 0) {
            return left;
        }

        int right = findWithDups(A, Math.max(A[mid], mid + 1), r);
        if (right >= 0) {
            return right;
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] A = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        // 7
        System.out.println(MagicIndex.findWithoutDups(A));

        int[] B = {-10, -5, 2, 2, 2, 3, 5, 7, 9, 12, 13};
        // 2
        System.out.println(MagicIndex.findWithDups(B));
    }

}
