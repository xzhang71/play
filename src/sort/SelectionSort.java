package sort;

/**
 * Created by xzhang on 6/23/14.
 */
public class SelectionSort extends Sort {

    public static void main(String[] args) {
        int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SelectionSort sort = new SelectionSort();
        sort.sort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public void sort(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[i]) {
                    int temp = input[j];
                    input[j] = input[i];
                    input[i] = temp;
                }
            }
        }
    }

}
