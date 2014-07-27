import java.util.LinkedList;

/**
 * Created by xzhang71 on 6/3/14.
 */
public class Main {

    private Main() {
    }


    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            ll.add(i);
        }
        for (int i : ll) {
            System.out.print(i + " ");
        }
    }
}