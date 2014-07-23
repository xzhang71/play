package sortAndSearch;

/**
 * Created by xzhang on 6/23/14.
 */
public class MergeSort {

    public static void recursivelySort(int[] A) {
        recursivelySort(A, new int[A.length], 0, A.length - 1);
    }

    private static void recursivelySort(int[] A, int[] cache, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = (l + r) / 2;
        recursivelySort(A, cache, l, mid);
        recursivelySort(A, cache, mid + 1, r);

        int i = l;
        int j = mid + 1;
        int k = l;
        while (i <= mid && j <= r) {
            if (A[i] <= A[j]) {
                cache[k] = A[i];
                i++;
                k++;
            } else {
                cache[k] = A[j];
                j++;
                k++;
            }
        }

        while (i <= mid) {
            cache[k] = A[i];
            i++;
            k++;
        }

        k--;
        while (k >= l) {
            A[k] = cache[k];
            k--;
        }
    }

    public static void iterativelySort(int[] A) {
        int[] cache = new int[A.length];

        for (int size = 1; size < A.length; size *= 2) {
            for (int left = 0; left + size < A.length; left += 2 * size) {
                // IMPORTANT
                int right = Math.min(left + 2 * size - 1, A.length - 1);
                int mid = left + size - 1;

                int i = left;
                int j = mid + 1;
                int k = left;
                while (i <= mid && j <= right) {
                    if (A[i] <= A[j]) {
                        cache[k] = A[i];
                        i++;
                        k++;
                    } else {
                        cache[k] = A[j];
                        j++;
                        k++;
                    }
                }

                while (i <= mid) {
                    cache[k] = A[i];
                    i++;
                    k++;
                }

                k--;
                while (k >= left) {
                    A[k] = cache[k];
                    k--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] A1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        MergeSort.recursivelySort(A1);
        for (int i = 0; i < A1.length; i++) {
            System.out.print(A1[i] + " ");
        }

        System.out.println();

        int[] A2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        MergeSort.iterativelySort(A2);
        for (int i = 0; i < A2.length; i++) {
            System.out.print(A2[i] + " ");
        }
    }
}