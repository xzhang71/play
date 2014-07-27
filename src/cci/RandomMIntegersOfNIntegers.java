package cci;

import java.util.Random;

/**
 * Created by xzhang71 on 7/26/14.
 */
public class RandomMIntegersOfNIntegers {

    public static int[] select(int[] A, int m) {
        if (m > A.length) {
            throw new RuntimeException("m greater than length of A");
        }

        int[] R = new int[m];
        for (int i = 0; i < m; i++) {
            R[i] = A[i];
        }

        Random rand = new Random();
        for (int i = m; i < A.length; i++) {
            int index = rand.nextInt(i + 1);
            if (index < m) {
                R[index] = A[i];
            }
        }

        return R;
    }

    public static void main(String[] args) {
        int[] A = new int[52];

        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }

        RandomShuffle.shuffle(A);
        int[] R = RandomMIntegersOfNIntegers.select(A, A.length - 1);

        for (int i = 0; i < R.length; i++) {
            System.out.print(R[i] + " ");
        }
    }
}