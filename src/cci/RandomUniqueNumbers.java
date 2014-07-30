package cci;

import java.util.Random;

/**
 * Created by xzhang71 on 7/29/14.
 */
public class RandomUniqueNumbers {

    public static int[] randomUniqueNumbers(int n, int m) {
        int[] result = new int[m];
        Random rand = new Random();

        while (m > 0) {
            if (rand.nextInt(n + 1) < m) {
                result[m - 1] = n;
                m--;
            }
            n--;
        }

        return result;
    }

    public static int[] randomUniqueNumbers(int[] arr, int m) {
        int[] result = new int[m];
        int n = arr.length;

        Random rand = new Random();
        while (m > 0) {
            if (rand.nextInt(n) < m) {
                result[m - 1] = arr[n - 1];
                m--;
            }
            n--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = RandomUniqueNumbers.randomUniqueNumbers(50, 25);
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] arr2 = RandomUniqueNumbers.randomUniqueNumbers(arr1, 10);
        for (int i : arr2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}