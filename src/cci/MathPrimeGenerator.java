package cci;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhang71 on 7/17/14.
 */
public class MathPrimeGenerator {

    public static List<Integer> generate(int n) {
        boolean[] flags = new boolean[n + 1];
        for (int i = 2; i < n + 1; i++) {
            flags[i] = true;
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            if (flags[i]) {
                primes.add(i);
                for (int j = i + 1; j < n + 1; j++) {
                    if (j % i == 0) {
                        flags[j] = false;
                    }
                }
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        List<Integer> primes = MathPrimeGenerator.generate(100);
        // 25
        System.out.println(primes.size());
        for (int p : primes) {
            System.out.print(p + " ");
        }
    }
}
