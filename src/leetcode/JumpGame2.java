package leetcode;

/**
 * Created by xzhang on 6/12/14.
 */
public class JumpGame2 {
    public static void main(String[] args) {
        JumpGame2 jg2 = new JumpGame2();
        int[] A = new int[25000 + 2];
        for (int i = 0; i < 25000; i++) {
            A[i] = 25000 - i;
        }
        A[A.length - 2] = 1;
        A[A.length - 1] = 0;
        System.out.println(jg2.jump(A));
    }

    public int jump(int[] A) {
        if (A == null || A.length == 0) return -1;

        int[] r = new int[A.length];
        r[0] = 1;

        for (int i = 1; i < A.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (r[j] > 0 && (A[j] >= i - j)) {
                    r[i] = r[i] == 0 ? r[j] + 1 : Math.min(r[i], r[j] + 1);
                }
            }
        }

        return r[r.length - 1] - 1;
    }
}
