package lee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhang on 6/11/14.
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        CombinationSum2 cs2 = new CombinationSum2();
        int[] num = {1, 1};
        int target = 2;
        List<List<Integer>> result = cs2.combinationSum(num, target);
        for (List<Integer> t1 : result) {
            for (int t2 : t1) {
                System.out.print(t2 + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) {
            // ERROR?
            return result;
        }

        quickSort(num);
        combinationSumGo(num, target, 0, result, new ArrayList<Integer>());
        return result;
    }

    public void combinationSumGo(int[] num, int target, int pos, List<List<Integer>> result, List<Integer> temp) {
        for (int i = pos; i < num.length; i++) {
            if (target > num[i]) {
                temp.add(num[i]);
                combinationSumGo(num, target - num[i], i + 1, result, temp);
                temp.remove(temp.size() - 1);
            } else if (target == num[i]) {
                List<Integer> dest = new ArrayList<>(temp);
                dest.add(num[i]);
                result.add(dest);
            } else {
                break;
            }
            // VARY IMPORTANT: remove duplicate integer list
            // wrap the block of code with if statement will prevent from using duplicate elements
            // eg. {1, 1} 2, the if statement only allows you to use 1 once and the result is empty
            // the right way to do it is to only allow the same value show up in this position once, it has nothing to do with the previous or the future
            // eg. {1, 1} 2, if pick the first 1 will give you some result, we are not going to repeat the work with the second 1 in the same loop
            // but in the next loop we may still use the second 1
            while(i != num.length - 1 && num[i + 1] == num[i]) {
                i++;
            }
        }
    }

    public void quickSort(int[] arr) {
        quickSortGo(arr, 0, arr.length - 1);
    }

    private void quickSortGo(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = arr[(left + right) / 2];
        int i = left;
        int j = right;
        while (i < j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                if (i < j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                i++;
                j--;
            }
        }

        quickSortGo(arr, left, j);
        quickSortGo(arr, i, right);
    }
}
