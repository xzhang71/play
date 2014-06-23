package sort;

/**
 * Created by xzhang on 6/23/14.
 */
public class QuickSort2 extends Sort {

    public static void main(String[] args) {
        int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        QuickSort2 sort = new QuickSort2();
        sort.sort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public void sort(int[] input) {
        sortGo(input, 0, input.length - 1);
    }

    public void sortGo(int[] input, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        int pivot = input[mid];
        int lp = left;
        int rp = right;

        while (lp < rp) {
            while (input[lp] < pivot) {
                lp++;
            }

            while (input[rp] > pivot) {
                rp--;
            }

            if (lp <= rp) {
                if (lp < rp) {
                    int temp = input[lp];
                    input[lp] = input[rp];
                    input[rp] = temp;
                }
                lp++;
                rp--;
            }
        }

        sortGo(input, left, rp);
        sortGo(input, lp, right);
    }

}
