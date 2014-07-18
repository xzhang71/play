package cci;

/**
 * Created by xzhang71 on 7/17/14.
 */
public class MathCheckPrimality {

    public static boolean prime(int n) {
        if (n <= 1) {
            return false;
        }

        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
