import java.util.*;

/**
 * Created by xzhang71 on 6/3/14.
 */
public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
        Queue<Integer> pq = new PriorityQueue<>(10, comp);
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
    }
}
