package cci;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhang71 on 7/17/14.
 */
public class BitMissingSearch {

    /**
     * Given a list that contains all the integers from 0 to n except for one, find the missing number within O(n) time. Assume the only operation to access the integers is get the jth bit of A.get(i)
     *
     * @param A
     * @return
     */
    public int search(List<BitInteger> A) {
        int n = 0;

        for (int i = 0; i < BitInteger.BIT_COUNT; i++) {
            List<BitInteger> odds = new ArrayList<>();
            List<BitInteger> evens = new ArrayList<>();

            for (BitInteger b : A) {
                if (b.getBit(i) == 0) {
                    evens.add(b);
                } else {
                    odds.add(b);
                }
            }

            if (odds.size() < evens.size()) {
                n += 1 << i;
                A = odds;
            } else {
                A = evens;
            }
        }

        return n;
    }

}

class BitInteger {

    static final int BIT_COUNT = 32;

    int getBit(int i) {
        return 0;
    }
}
