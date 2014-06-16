package lee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xzhang on 6/16/14.
 */

// TODO: FIND THE BUG

public class Combinations {
    public static void main(String[] args) {
        Combinations c = new Combinations();
        List result = c.combine(4, 2);
        System.out.println(result.size());
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > n) {
            return result;
        }

        combineGo(1, n, k, new ArrayList<Integer>(), result);
        return result;
    }

    private void combineGo(int from, int to, int index, List<Integer> list, List<List<Integer>> result) {
        if (index == 0) {
            List<Integer> temp = new ArrayList<>(list);
            result.add(temp);
            return;
        }

        for (int i = from; i <= to; i++) {
            list.add(i);
            combineGo(from + 1, to, index - 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}
