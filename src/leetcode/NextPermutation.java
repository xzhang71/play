package leetcode;

/**
 * Created by xzhang on 6/10/14.
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] num = {5, 4, 7, 5, 3, 2};
        nextPermutation(num);
    }

    public static void nextPermutation(int[] num) {
        if (num == null || num.length <= 1) {
            return;
        }

        int i = num.length - 1;

        while (i >= 0) {
            if (i == 0) {
                insert(num, 0);
                return;
            } else if (num[i - 1] < num[i]) {
                insert(num, i);
                int j = i;
                while (j < num.length && num[j] <= num[i - 1]) {
                    j++;
                }
                int temp = num[i - 1];
                num[i - 1] = num[j];
                num[j] = temp;
                return;
            } else {
                insert(num, i);
            }

            i--;
        }
    }

    private static void insert(int[] num, int i) {
        while (i < num.length - 1 && num[i] > num[i + 1]) {
            int temp = num[i];
            num[i] = num[i + 1];
            num[i + 1] = temp;
            i++;
        }
    }
}
