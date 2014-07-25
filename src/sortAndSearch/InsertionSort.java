package sortAndSearch;

/**
 * Created by xzhang71 on 7/20/14.
 */
public class InsertionSort {

    public static void sort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0 && input[j - 1] > input[j]; j--) {
                int temp = input[j - 1];
                input[j - 1] = input[j];
                input[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        InsertionSort.sort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}