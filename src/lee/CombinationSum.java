package lee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xzhang on 6/11/14.
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = {1, 2};
        int target = 2;
        List<List<Integer>> result = cs.combinationSum(candidates, target);
        for (List<Integer> t1 : result) {
            for (int t2 : t1) {
                System.out.print(t2 + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            // ERROR?
            return result;
        }

        quickSort(candidates);
        combinationSumGo(candidates, target, 0, result, new ArrayList<Integer>());
        return result;
    }

    public void combinationSumGo(int[] candidates, int target, int pos, List<List<Integer>> result, List<Integer> temp) {
        for (int i = pos; i < candidates.length; i++) {
            if (target > candidates[i]) {
                temp.add(candidates[i]);
                combinationSumGo(candidates, target - candidates[i], i, result, temp);
                temp.remove(temp.size() - 1);
            } else if (target == candidates[i]) {
                List<Integer> dest = new ArrayList<>();
                for (int t : temp) {
                    dest.add(t);
                }
                dest.add(candidates[i]);
                result.add(dest);
            } else {
                break;
            }
        }
    }

    public static void quickSort(int[] arr) {
        quickSortGo(arr, 0, arr.length - 1);
    }

    private static void quickSortGo(int[] arr, int left, int right) {
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