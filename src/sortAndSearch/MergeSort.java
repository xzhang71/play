package sortAndSearch;

/**
 * Created by xzhang on 6/23/14.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] input1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        MergeSort.recursivelySort(input1);
        for (int i = 0; i < input1.length; i++) {
            System.out.print(input1[i] + " ");
        }

        System.out.println();

        int[] input2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        MergeSort.iterativelySort(input2);
        for (int i = 0; i < input2.length; i++) {
            System.out.print(input2[i] + " ");
        }
    }

    public static void recursivelySort(int[] input) {
        recursivelySort(input, new int[input.length], 0, input.length - 1);
    }

    private static void recursivelySort(int[] input, int[] cache, int left, int right) {
        if (left == right) {
            return;
        }

        int lmid = (left + right) / 2;
        int rmid = lmid + 1;
        recursivelySort(input, cache, left, lmid);
        recursivelySort(input, cache, rmid, right);

        int i = left;
        int j = rmid;
        int k = left;
        while (i <= lmid && j <= right) {
            if (input[i] <= input[j]) {
                cache[k] = input[i];
                i++;
                k++;
            } else {
                cache[k] = input[j];
                j++;
                k++;
            }
        }

        while (i <= lmid) {
            cache[k] = input[i];
            i++;
            k++;
        }

        k--;
        while (k >= left) {
            input[k] = cache[k];
            k--;
        }
    }

    public static void iterativelySort(int[] input) {
        int[] cache = new int[input.length];
        for (int size = 1; size < input.length; size *= 2) {
            for (int left = 0; left + size < input.length; left += size * 2) {
                int lmid = left + size - 1;
                int rmid = lmid + 1;
                int right = Math.min(left + 2 * size - 1, input.length - 1);

                int i = left;
                int j = rmid;
                int k = left;
                while (i <= lmid && j <= right) {
                    if (input[i] <= input[j]) {
                        cache[k] = input[i];
                        i++;
                        k++;
                    } else {
                        cache[k] = input[j];
                        j++;
                        k++;
                    }
                }

                while (i <= lmid) {
                    cache[k] = input[i];
                    i++;
                    k++;
                }

                k--;
                while (k >= left) {
                    input[k] = cache[k];
                    k--;
                }
            }
        }
    }
}