package cci;

import java.util.*;

/**
 * Created by xzhang71 on 7/23/14.
 */
public class TwoSum {

    public static List<int[]> twoSum(int[] A, int val) {
        List<int[]> result = new ArrayList<>();
        Set<Integer> cache = new HashSet<>();

        for (int i : A) {
            if (cache.contains(i)) {
                cache.remove(i);
                result.add(new int[]{i, val - i});
            } else {
                cache.add(val - i);
            }
        }

        return result;
    }

    public static List<int[]> twoSum2(int[] A, int val) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(A);

        int i = 0;
        int j = A.length - 1;

        while (i < j) {
            int sum = A[i] + A[j];
            if (sum == val) {
                result.add(new int[]{A[i], A[j]});
                i++;
                j--;
            } else if (sum < val) {
                i++;
            } else {
                j--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int val = 7;
        List<int[]> result = TwoSum.twoSum(A, val);
        for (int[] e : result) {
            System.out.printf("%d %d\n", e[0], e[1]);
        }

        System.out.println();

        result = TwoSum.twoSum2(A, val);
        for (int[] e : result) {
            System.out.printf("%d %d\n", e[0], e[1]);
        }
    }
}
