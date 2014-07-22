package cci;

/**
 * Created by xzhang71 on 7/21/14.
 */
public class Swap {
    public static void swap(int a, int b) {
        System.out.printf("a=%d, b=%d\n", a, b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.printf("a=%d, b=%d\n", a, b);
    }


    public static void main(String[] args) {
        Swap.swap(123456789, -987654321);
    }
}
