import leetcode.domain.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhang71 on 6/3/14.
 */
public class Main {
    public static void main(String[] args) {
        String path = "/.";
        String[] paths = path.split("/");
        for (String str : paths) {
            System.out.println("output: " + str);
        }
    }
}
