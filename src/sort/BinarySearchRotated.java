package sort;

/**
 * Created by xzhang on 6/23/14.
 */
public class BinarySearchRotated {

    public static void main(String[] args) {
        BinarySearchRotated bsr = new BinarySearchRotated();

        int[] input1 = {3, 1, 2};
        System.out.println(bsr.binarySearchRotated(input1, 3));

        int[] input2 = {3, 1, 1};
        System.out.println(bsr.binarySearchRotatedDuplicate(input2, 3));
    }

    public int binarySearchRotated(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int left = 0;
        int right = A.length - 1;

        while (left <= right) {
            if (left == right) {
                if (A[left] == target) {
                    return left;
                } else {
                    return -1;
                }
            }

            int mid = (left + right) / 2;

            if (A[left] <= A[mid]) {
                if (A[left] <= target && target <= A[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (A[mid + 1] <= target && target <= A[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }

        return -1;
    }

    public int binarySearchRotatedDuplicate(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int left = 0;
        int right = A.length - 1;

        while (left <= right) {
            if (left == right) {
                if (A[left] == target) {
                    return left;
                } else {
                    return -1;
                }
            }

            int lmid = (left + right) / 2;
            int rmid = lmid + 1;

            while (lmid > left && A[lmid] == A[left]) {
                lmid--;
            }

            while (rmid < right && A[rmid] == A[rmid]) {
                rmid++;
            }

            if (A[rmid] <= A[right]) {
                if (A[rmid] < target && target <= A[right]) {
                    left = rmid;
                } else {
                    right = lmid;
                }
            } else {
                if (A[left] <= target && target <= A[lmid]) {
                    right = lmid;
                } else {
                    left = rmid;
                }
            }
        }

        return -1;
    }
}
