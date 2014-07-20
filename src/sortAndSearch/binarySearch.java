package sortAndSearch;

/**
 * Created by xzhang71 on 7/20/14.
 */
public class BinarySearch {
    public static int binarySearch(int[] input, int val) {
        int l = 0;
        int r = input.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (input[mid] == val) {
                return mid;
            } else if (input[mid] < val) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        QuickSort.sort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();

        // 4
        System.out.println(BinarySearch.binarySearch(input, 5));
    }
}
