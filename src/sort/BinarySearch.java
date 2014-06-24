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

            if (input[mid] >= target) {
                right = mid;
            } else {
                right = mid + 1;
            }
        }

        return -1;
    }

    /**
     * Ascending order
     *
     * first less than
     * if(input[mid] < target) {
     *     right = mid;
     * } else {
     *     left = mid + 1;
     * }
     *
     * first less than or equal to
     * if(input[mid] <= target) {
     *     right = mid;
     * } else {
     *     left = mid + 1;
     * }
     *
     * first equal to
     * if(input[mid + 1] > target) {
     *     right = mid;
     * } else {
     *     left = mid + 1;
     * }
     *
     * first greater than
     * if(input[mid] > target) {
     *     right = mid;
     * } else {
     *     left = mid + 1;
     * }
     *
     * first greater than or equal to
     * if(input[mid] >= target) {
     *     right = mid;
     * } else {
     *     left = mid + 1;
     * }
     *
     * last less than
     * if(input[mid + 1] < target) {
     *     left = mid + 1;
     * } else {
     *     right = mid;
     * }
     *
     * last less than or equal to
     * if(input[mid + 1] <= target) {
     *     left = mid + 1;
     * } else {
     *     right = mid;
     * }
     *
     * last equal to
     * if(input[mid + 1] > target) {
     *     right = mid;
     * } else {
     *     left = mid + 1;
     * }
     *
     * last greater than
     * if(input[mid + 1] > target) {
     *     left = mid + 1;
     * } else {
     *     right = mid;
     * }
     *
     * last greater than or equal to
     * if(input[mid + 1] >= target) {
     *     left = mid + 1;
     * } else {
     *     right = mid;
     * }
     *
     */

    /**
     * Descending order
     *
     * first less than
     * if(input[mid] < target) {
     *     right = mid;
     * } else {
     *      left = mid + 1;
     * }
     *
     * first less than or equal to
     * if(input[mid] <= target) {
     *      right = mid;
     * } else {
     *     left = mid + 1;
     * }
     *
     * first equal to
     * if(input[mid] > target) {
     *     left = mid + 1;
     * } else {
     *     right = mid;
     * }
     *
     * first greater than
     * if(input[mid] > target) {
     *     right = mid;
     * } else {
     *     left = mid + 1;
     * }
     *
     * first greater than or equal to
     * if(input[mid] >= target) {
     *     right = mid + 1;
     * } else {
     *     left = mid;
     * }
     *
     * last less than
     * if(input[mid + 1] < target) {
     *     left = mid + 1;
     * } else {
     *     right = mid;
     * }
     *
     * last less than or equal to
     * if(input[mid + 1] <= target) {
     *     left = mid + 1;
     * } else {
     *     right = mid;
     * }
     *
     * last equal
     * if(input[mid] > target) {
     *     left = mid + 1;
     * } else {
     *     right = mid;
     * }
     *
     * last greater than
     * if(input[mid + 1] >= target) {
     *     left = mid + 1;
     * } else {
     *     right = mid;
     * }
     *
     * last greater than or equal to
     * if(input[mid + 1] >= target) {
     *     left = mid + 1;
     * } else {
     *     right = mid;
     * }
     */
}