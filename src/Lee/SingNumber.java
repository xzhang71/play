package lee;

/**
 * Created by xzhang71 on 6/9/14.
 */
public class SingNumber {
    public static int singleNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        for (int i : arr) {
            int fives = (fours & i);
            fours = (fours | (threes & i)) & ~fives;
            threes = (threes | (twos & i)) & ~(fours | fives);
            twos = (twos | (ones & i)) & ~(threes | fours | fives);
            ones = (ones ^ i) & ~(twos | threes | fours | fives);
        }
        return ones;
    }

    public static int[] mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        int[] rs = new int[nums.length];
        go(temp, 0, temp.length - 1, rs);
        return rs;
    }

    private static void go(int[] temp, int left, int right, int[] rs) {
        if (left == right) {
            rs[left] = temp[right];
            return;
        }
        int mid = (left + right) / 2;
        go(temp, left, mid, rs);
        go(temp, mid + 1, right, rs);
        int k = left, i = left, j = mid + 1;
        while (i <= mid || j <= right) {
            if (i <= mid && j <= right) {
                if (rs[i] <= rs[j]) {
                    temp[k] = rs[i];
                    i++;
                } else {
                    temp[k] = rs[j];
                    j++;
                }
            } else if (i <= mid) {
                temp[k] = rs[i];
                i++;
            } else {
                temp[k] = rs[j];
                j++;
            }
            k++;
        }

        k = left;
        while (k >= left && k <= right) {
            rs[k] = temp[k];
            k++;
        }
    }

}
