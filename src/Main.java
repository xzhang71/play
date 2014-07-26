
/**
 * Created by xzhang71 on 6/3/14.
 */
public class Main {

    private Main() {
    }


    public static void main(String[] args) {
        int a = -2147483647;
        int b = -2;
        System.out.println(a + b);

        int c = 2147483647;
        int d = 2;
        System.out.println(~(c + d) + 1);

        int e = -2147483647;
        int f = 2;
        // e - f = e + (-f)
        System.out.println(e + (~f + 1));
    }
}