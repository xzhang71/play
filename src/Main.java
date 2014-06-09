import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xzhang71 on 6/3/14.
 */
public class Main {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
        Queue<Integer> pq = new PriorityQueue<Integer>(10, comp);
    }
}
