package cci;

import java.util.Random;

/**
 * Created by xzhang71 on 7/26/14.
 */
public class RandomShuffle {

    public static void shuffle(int[] A) {
        Random rand = new Random();
        for (int i = 0; i < A.length; i++) {
            int index = rand.nextInt(i + 1);
            int temp = A[i];
            A[i] = A[index];
            A[index] = temp;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[52];
        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }

        for (int i = 0; i < 10; i++) {
            RandomShuffle.shuffle(A);
        }

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }
}