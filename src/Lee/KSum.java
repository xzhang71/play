package Lee;

import java.util.*;

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

        System.out.println("-----------------");
        // int[] input = {-9, 14, -7, -8, 9, 1, -10, -8, 13, 12, 6, 9, 3, -3, -15, -15, 1, 8, -7, -4, -6, 8, 2, -10, 8, 11, -15, 3, 0, -11, -1, -1, 10, 0, 6, 5, -14, 3, 12, -15, -7, -5, 9, 11, -1, 1, 3, -15, -5, 11, -12, -4, -4, -2, -6, -10, -6, -6, 0, 2, -9, 14, -14, -14, -9, -1, -2, -7, -12, -13, -15, -4, -3, 1, 14, 3, -12, 3, 3, -10, -9, -1, -7, 3, 12, -6, 0, 13, 4, -15, 0, 2, 6, 1, 3, 13, 8, -13, 13, 11, 11, 13, 14, -6};
        int[] input = {1, 0, 0, 0, 0};
        List<List<Integer>> ll = threeSum(input);
        for (List<Integer> l : ll) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> ll = new ArrayList<>();
        if (num == null || num.length < 4) return ll;

        Arrays.sort(num);
        for (int i = 0; i <= num.length - 4; i++) {
            if (i == 0 || num[i] != num[i - 1]) {
                for (int j = i + 1; j <= num.length - 3; j++) {
                    if (j == i + 1 || num[j] != num[j - 1]) {
                        int p = j + 1;
                        int q = num.length - 1;
                        while (p < q) {
                            int sum = num[i] + num[j] + num[p] + num[q];
                            if (sum > target) {
                                q--;
                                while (p < q && num[q] == num[q + 1]) q--;
                            } else if (sum < target) {
                                p++;
                                while (p < q && num[p] == num[p - 1]) p++;
                            } else {
                                List<Integer> l = new ArrayList<>();
                                l.add(num[i]);
                                l.add(num[j]);
                                l.add(num[p]);
                                l.add(num[q]);
                                ll.add(l);
                                p++;
                                q--;
                                while (p < q && num[q] == num[q + 1]) q--;
                                while (p < q && num[p] == num[p - 1]) p++;
                            }
                        }
                    }
                }
            }
        }
        return ll;
    }

    public int threeSumClosest(int[] num, int target) {
        // based on the assumption that there will be one and only one solution, 0 will be overridden always
        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += num[i];
        }
        // the distance which is non negative
        int min = Integer.MAX_VALUE;
        if (num == null || num.length <= 2) return result;

        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || num[i] != num[i - 1]) { // avoid duplicate, here helps to improve performance slightly
                int j = i + 1;
                int k = num.length - 1;
                while (j < k) {
                    int sum = num[i] + num[j] + num[k];
                    int temp = Math.abs(sum - target);
                    if (min > temp) {
                        min = temp;
                        result = sum;
                    }
                    if (sum == target) {
                        // if find all, here is the place to store the values
                        // j++;
                        // k--;
                        // while (j < k && num[j] == num[j - 1]) j++; // avoid duplicates
                        // while (j < k && num[k] == num[k + 1]) k--; // avoid duplicates
                        return target;
                    } else if (sum < target) {
                        j++;
                        while (j < k && num[j] == num[j - 1]) j++;
                    } else {
                        k--;

                        while (j < k && num[k] == num[k + 1]) k--;
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> ll = new ArrayList<>();
        if (num == null) return ll;

        nonRecursiveMergeSort(num);
        for (int i = 0; i < num.length; i++) {
            // avoid duplicate solutions
            // if num[i - 1] == num [i] and num[i - 1] can be part of one or many three sums
            // num[i] may or may not be part of one or many three sums (eg. num[i - 1], num[i], ... is a three sum, num[i], ... , ... may not be a three sum)
            // even if num[i] can be part of one or many three sums, the three sums would be a subset of three sums of num[i - 1]
            if (i == 0 || num[i] != num[i - 1]) {
                int twoSum = 0 - num[i];
                int j = i + 1;
                int k = num.length - 1;
                while (j < k) {
                    int sum = num[j] + num[k];
                    if (sum < twoSum) {
                        j++;
                    } else if (sum > twoSum) {
                        k--;
                    } else {
                        List<Integer> l = new ArrayList<>();
                        l.add(num[i]);
                        l.add(num[j]);
                        l.add(num[k]);
                        ll.add(l);
                        j++;
                        k--;
                        while (j < k && num[k] == num[k + 1]) k--; // avoid duplicate solutions
                        while (j < k && num[j] == num[j - 1]) j++; // avoid duplicate solutions
                    }
                }
            }
        }
        return ll;
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
                // pay attention to the Math.min(left + size * 2 - 1, result.length - 1)
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
