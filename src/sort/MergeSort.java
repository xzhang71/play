package sort;

/**
 * Created by xzhang on 6/23/14.
 */
public class MergeSort extends Sort {

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();

        int[] input1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort.sortR(input1);
        for (int i = 0; i < input1.length; i++) {
            System.out.print(input1[i] + " ");
        }

        System.out.println();

        int[] input2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort.sortR(input2);
        for (int i = 0; i < input2.length; i++) {
            System.out.print(input2[i] + " ");
        }
    }

    public void sort(int[] input) {

    }

    public void sortR(int[] input) {
        int[] cache = new int[input.length];
        sortRGo(input, cache, 0, input.length - 1);
    }

    private void sortRGo(int[] input, int[] cache, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        sortRGo(input, cache, left, mid);
        sortRGo(input, cache, mid + 1, right);

        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
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

        while (i <= mid) {
            cache[k] = input[i];
            i++;
            k++;
        }

        k = left;
        while (k <= right) {
            input[k] = cache[k];
            k++;
        }
    }

    public void sortNonR(int[] input) {
        int[] cache = new int[input.length];
        for (int i = 1; i < input.length; i *= 2) {
            for (int left = 0; left < input.length - i; left += i * 2) {
                int right = left + i * 2 - 1;
                int mid = (left + right) / 2;
                int lp = left;
                int rp = mid + 1;
                int p = left;
                while (lp <= mid && rp <= right) {
                    if (input[lp] <= input[rp]) {
                        cache[p] = input[lp];
                        lp++;
                        p++;
                    } else {
                        cache[p] = input[rp];
                        rp++;
                        p++;
                    }
                }

                while (lp <= mid) {
                    cache[p] = input[lp];
                    lp++;
                    p++;
                }

                p = left;
                while (p <= right) {
                    input[p] = cache[p];
                }
            }
        }
    }

}
