package sort;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        // int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int k = 0; k < 20; k++) {
            Random rand = new Random(k);
            int[] arr = new int[k];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = rand.nextInt();
            }
            quickSort(arr);
            boolean result = true;
            for (int i = 1; i < arr.length; i++) {
                result = result && arr[i] > arr[i - 1];
            }
            System.out.println(result);
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
            // without arr[k] == pivot
            // think of {5, 3}
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