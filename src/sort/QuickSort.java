package sort;

/**
 * Created by xzhang on 6/23/14.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        QuickSort.sort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public static void sort(int[] input) {
        sort(input, 0, input.length - 1);
    }

    public static void sort(int[] input, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = input[(left + right) / 2];
        int i = left;
        int j = right;

        while (i < j) {
            while (input[i] < pivot) {
                i++;
            }

            while (input[j] > pivot) {
                j--;
            }

            if (i <= j) {
                if (i != j) {
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
                i++;
                j--;
            }
        }

        sort(input, left, j);
        sort(input, i, right);
    }
}