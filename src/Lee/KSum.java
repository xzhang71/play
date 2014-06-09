package Lee;

import java.util.Random;

/**
 * Created by xzhang71 on 6/8/14.
 */
public class KSum {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[7];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt();
        }

        System.out.println("-----------------");
        int[] result1 = recursiveMergeSort(arr);
        for (int i : result1) {
            System.out.println(i);
        }

        System.out.println("-----------------");
        int[] result2 = nonRecursiveMergeSort(arr);
        for (int i : result2) {
            System.out.println(i);
        }

    }

    public static void twoSum(int[] arr) {

    }

    public static int[] nonRecursiveMergeSort(int[] arr) {
        if (arr == null) return new int[0];
        int[] temp = new int[arr.length];
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        for (int size = 1; size < result.length; size = size * 2) {
            // pay attention to the left + size - 1
            // if left + size - 1 >= result.length - 1
            // then there is only left side or part of the left side and no right side, there is no need to merge
            // this also avoids mid and mid + 1 being out of range
            for (int left = 0; left + size - 1 < result.length - 1; left = left + size * 2) {
                int mid = left + size - 1;
                int right = Math.min(left + size * 2 - 1, result.length - 1);
                int i = left, j = mid + 1, k = left;
                while (i <= mid || j <= right) {
                    if (i > mid) {
                        temp[k] = result[j];
                        j++;
                    } else if (j > right) {
                        temp[k] = result[i];
                        i++;
                    } else {
                        if (result[i] <= result[j]) {
                            temp[k] = result[i];
                            i++;
                        } else {
                            temp[k] = result[j];
                            j++;
                        }
                    }
                    k++;
                }
                for (int x = left; x <= right; x++) {
                    result[x] = temp[x];
                }
            }
        }
        return result;
    }

    public static int[] recursiveMergeSort(int[] arr) {
        if (arr == null) return new int[0]; // ERROR?
        int[] temp = new int[arr.length];
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i];
        }
        recursiveMergeSortGo(result, temp, 0, result.length - 1);
        return result;
    }

    public static void recursiveMergeSortGo(int[] result, int[] temp, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        recursiveMergeSortGo(result, temp, left, mid);
        recursiveMergeSortGo(result, temp, mid + 1, right);
        int i = left, j = mid + 1, k = left;
        while (i <= mid || j <= right) {
            if (i > mid) {
                temp[k] = result[j];
                j++;
            } else if (j > right) {
                temp[k] = result[i];
                i++;
            } else {
                if (result[i] <= result[j]) {
                    temp[k] = result[i];
                    i++;
                } else {
                    temp[k] = result[j];
                    j++;
                }
            }
            k++;
        }
        for (int x = left; x <= right; x++) {
            result[x] = temp[x];
        }
    }

}
