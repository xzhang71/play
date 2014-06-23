package sort;

/**
 * Created by xzhang on 6/23/14.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch(input, 0));
    }

    public int binarySearch(int[] input, int target) {
        int left = 0;
        int right = input.length - 1;

        while (left <= right) {
            if (left == right) {
                if (input[left] == target) {
                    return left;
                } else {
                    return -1 - left;
                }
            }

            int mid = (left + right) / 2;

            if (input[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
