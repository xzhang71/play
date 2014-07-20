package sortAndSearch;

/**
 * Created by xzhang on 6/23/14.
 */
public class BubbleSort {

    public static void sort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            for (int j = 1; j < input.length; j++) {
                if (input[j - 1] > input[j]) {
                    int temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        BubbleSort.sort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}