package sortAndSearch;

/**
 * Created by xzhang71 on 7/20/14.
 */
public class BinarySearchRotated {

    public static int binarySearchWithoutDups(int[] input, int val) {
        int l = 0;
        int r = input.length - 1;
        while (l <= r) {
            if (l == r) {
                if (input[l] == val) {
                    return l;
                } else {
                    return -1;
                }
            }

            int mid = (l + r) / 2;

            if (input[l] > input[mid]) {
                if (input[mid + 1] <= val && val <= input[r]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            } else {
                if (input[l] <= val && val <= input[mid]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
        }

        return -1;
    }

    public static int binarySearchWithDups(int[] input, int val) {
        int l = 0;
        int r = input.length - 1;
        while (l <= r) {
            if (l == r) {
                if (input[l] == val) {
                    return l;
                } else {
                    return -1;
                }
            }

            int lmid = (l + r) / 2;
            int rmid = lmid + 1;

            while (l < lmid && input[l] == input[lmid]) {
                lmid--;
            }

            while (rmid < r && input[rmid] == input[r]) {
                rmid++;
            }

            if (input[l] > input[lmid]) {
                if (input[rmid] <= val && val <= input[r]) {
                    l = rmid;
                } else {
                    r = lmid;
                }
            } else {
                if (input[l] <= val && val <= input[lmid]) {
                    r = lmid;
                } else {
                    l = rmid;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] input = {7, 8, 9, 0, 1, 2, 3, 4, 5, 6};
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i] + "->" + BinarySearchRotated.binarySearchWithoutDups(input, input[i]));
        }
        System.out.println();

        int[] input2 = {7, 7, 8, 8, 9, 9, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        for (int i = 0; i < input2.length; i++) {
            System.out.println(input2[i] + "->" + BinarySearchRotated.binarySearchWithDups(input2, input2[i]));
        }
        System.out.println();
    }
}