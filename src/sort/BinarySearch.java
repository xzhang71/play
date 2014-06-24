package sort;

/**
 * Created by xzhang on 6/23/14.
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();

        int[] input1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(bs.binarySearch(input1, 1));

        int[] input2 = {1, 2, 2};
        System.out.println(bs.binarySearchDuplicate(input2, 2));
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

            if (input[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return -1;
    }

    public int binarySearchDuplicate(int[] input, int target) {
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

            if (input[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return -1;
    }
}