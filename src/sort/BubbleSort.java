package sort;

/**
 * Created by xzhang on 6/23/14.
 */
public class BubbleSort extends Sort {

    public static void main(String[] args) {
        int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        BubbleSort sort = new BubbleSort();
        sort.sort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public void sort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 1; j < input.length; j++) {
                if (input[j - 1] > input[j]) {
                    int temp = input[j - 1];
                    input[j - 1] = input[j];
                    input[j] = temp;
                }
            }
        }
    }
}
