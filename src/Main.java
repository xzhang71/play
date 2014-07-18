import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xzhang71 on 6/3/14.
 */
public class Main {


    public static void main(String[] args) {
        List outer = new ArrayList();

        if (true) {
            List inner = new ArrayList();
            inner.add(new Object());

            outer = inner;
        }

        System.out.println(outer.size());
    }
}
