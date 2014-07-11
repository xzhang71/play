package cci;

/**
 * Created by xzhang on 7/10/14.
 */
public class RotatedSortedArray {

    /**
     * A sorted array has been rotated so that the elements might appear in the order 7, 1, 2, 3, 4, 5, 6. How would you find the minimum element?
     */

    /*
    public static int min(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Integer.MIN_VALUE;
        }

        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[l] <= arr[r]) {
                return arr[l];
            } else {
                if (arr[mid] < arr[r]) {
                    r = mid;
                } else {
                    l = mid;
                }
            }
        }

        return Integer.MIN_VALUE;
    }
    */
    public static int min(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Integer.MIN_VALUE;
        }

        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[l] <= arr[r]) {
                return arr[l];
            } else {
                if (arr[mid] < arr[r]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
        }

        return Integer.MIN_VALUE;
    }

    /**
     * A sorted array has been rotated so that the elements might appear in the order 7, 1, 2, 2, 2, 2, 7, 7, 7. How would you find the minimum element?
     */

    public static int min2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Integer.MIN_VALUE;
        }

        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            if (l == r || arr[l] < arr[r]) {
                return arr[l];
            }

            int midl = (l + r) / 2;
            int midr = midl + 1;

            while (l < midl && arr[l] == arr[midl]) {
                midl--;
            }

            while (midr < r && arr[midr] == arr[r]) {
                midr++;
            }

            if (arr[l] <= arr[midl]) {
                l = midr;
            } else {
                r = midl;
            }
        }

        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 5, 6, 7, 1};
        System.out.println(RotatedSortedArray.min(arr));

        int[][] arr2 = new int[][]{{7, 1, 2, 2, 2, 2, 7, 7, 7}, {1, 2}, {2, 1}, {2, 1, 1}, {2, 2, 1}};
        for (int[] a : arr2) {
            System.out.println(RotatedSortedArray.min2(a));
        }
    }
}
