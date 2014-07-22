import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xzhang71 on 6/3/14.
 */
public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 32; i++) {
            System.out.println(0x80000000 >> i);
        }
    }
}