package leetcode;

/**
 * Created by xzhang on 6/16/14.
 */

// TODO: FIND THE BUG

public class SearchInRotatedSortedArray2 {

    public static void main(String[] args) {
        SearchInRotatedSortedArray2 obj = new SearchInRotatedSortedArray2();
        int[] A = {5,1,3};
        int target = 1;
        System.out.println(obj.search(A, target));
    }

    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }

        int left = 0;
        int right = A.length - 1;

        while (left <= right) {
            if (left == right) {
                if (A[left] == target) {
                    return true;
                } else {
                    return false;
                }
            }

            int mid1 = (left + right) / 2;
            int mid2 = mid1 + 1;

            while (A[left] == A[mid1] && left < mid1) {
                mid1--;
            }

            while (A[mid2] == A[right] && mid2 < right) {
                mid2++;
            }

            if (target <= A[mid1]) {
                if (A[left] <= target && target <= A[mid1]) {
                    right = mid1;
                } else {
                    left = mid2;
                }
            } else {
                if (A[mid2] <= target && target <= A[right]) {
                    left = mid2;
                } else {
                    right = mid1;
                }
            }
        }

        return false;
    }
}
