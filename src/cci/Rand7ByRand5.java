package cci;

import java.util.Random;

/**
 * Created by xzhang71 on 7/23/14.
 */
public class Rand7ByRand5 {

    public static int rand7() {
        while (true) {
            int sum = rand5() * 5 + rand5();
            if (sum < 21) {
                return sum % 7;
            }
        }
    }

    public static int rand5() {
        Random rand = new Random();
        return rand.nextInt(5);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println(Rand7ByRand5.rand7());
        }
    }
}
