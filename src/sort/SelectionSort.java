package sort;

/**
 * Created by xzhang on 6/23/14.
 */
public class SelectionSort {

    public static void sort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int min = input[i];
            int minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < min) {
                    min = input[j];
                    minIndex = j;
                }
            }
            input[minIndex] = input[i];
            input[i] = min;
        }
    }

    public static void main(String[] args) {
        int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SelectionSort.sort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}