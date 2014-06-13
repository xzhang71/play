package lee;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhang on 6/13/14.
 */
public class PowXN {

    public static void main(String[] args) {
        PowXN pxn = new PowXN();
        System.out.println(pxn.pow(0.00001, 2147483647));
    }

    public double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double result = 1.0;
        if (n == Integer.MIN_VALUE) {
            result = x;
            n++;
        }

        int m = n;
        if (n <= 0) {
            m = -n;
        }

        Map<Integer, Double> map = new HashMap<>();
        map.put(0, 1.0);
        map.put(1, x);

        int i = 1;

        // IMPORTANT while loop condition
        while (i <= (m >> 1)) {
            double last = map.get(i);
            i = i << 1;
            map.put(i, last * last);
        }

        while (i > 0) {
            result *= map.get(m & i);
            i = i >> 1;
        }

        return n < 0 ? 1 / result : result;
    }
}
