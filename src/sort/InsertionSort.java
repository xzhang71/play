package sort;

/**
 * Created by xzhang71 on 7/20/14.
 */
public class InsertionSort {

    public static void sort(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j > 0 && input[j] < input[j - 1]; j--) {
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