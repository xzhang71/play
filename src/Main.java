import java.util.*;

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
        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> list = new ArrayList<>();
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7};
    }
}
