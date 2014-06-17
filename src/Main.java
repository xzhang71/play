import java.util.*;

/**
 * Created by xzhang71 on 6/3/14.
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
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
                }
            }

            int mid = (left + right) / 2;

            if (target <= A[mid]) {
                if (A[left] < A[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (A[mid + 1] < A[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }

        return false;
    }
}
