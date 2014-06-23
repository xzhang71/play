package sort;

/**
 * Created by xzhang on 6/23/14.
 */
public class BinarySearchRotated {

    public static void main(String[] args) {
        int[] input = {5};
        BinarySearchRotated bsr = new BinarySearchRotated();
        System.out.print(bsr.searchRotated(input, 9));
    }

    public int searchRotated(int[] input, int target) {
        if (input == null) {
            return -1;
        }

        int left = 0;
        int right = input.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (input[mid] == target) {
                return mid;
            } else if (input[left] < input[mid]) {
                if (input[left] <= target && target <= input[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (input[mid] <= target && target <= input[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
