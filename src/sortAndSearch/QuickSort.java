package sortAndSearch;

/**
 * Created by xzhang on 6/23/14.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] A = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        QuickSort.sort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    public static void sort(int[] A) {
        sort(A, 0, A.length - 1);
    }

    public static void sort(int[] A, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        int pivot = A[mid];

        int i = left;
        int j = right;
        while (i <= j) {
            while (A[i] < pivot) {
                i++;
            }

            while (pivot < A[j]) {
                j--;
            }

            if (i <= j) {
                if (i != j) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
                i++;
                j--;
            }
        }

        sort(A, left, j);
        sort(A, i, right);
    }
}