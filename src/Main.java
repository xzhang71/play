
/**
 * Created by xzhang71 on 6/3/14.
 */
public class Main {

    private Main() {
    }


    public static void main(String[] args) {
        for (int i = 0; i < 32; i++) {
            System.out.println(0x80000000 >> i);
        }
    }
}