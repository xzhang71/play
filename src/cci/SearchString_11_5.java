package cci;

/**
 * Created by xzhang71 on 6/23/14.
 */
public class SearchString_11_5 {

    public static void main(String[] args) {
        SearchString_11_5 ss = new SearchString_11_5();

        String[] input = {"", "", "aaa", "", "", "bbb", "", "", "ccc", "", "", "ddd", "", ""};
        String target = "bbb";
        int result = ss.searchString(input, target);
        System.out.println(result);
    }

    public int searchString(String[] input, String target) {
        if (input == null || input.length == 0 || target == null || target == "") {
            return -1;
        }

        int left = 0;
        int right = input.length - 1;

        while (left <= right) {
            if (left == right) {
                if (target.equals(input[left])) {
                    return left;
                } else {
                    return -1;
                }
            }

            int lmid = (left + right) / 2;
            int rmid = lmid + 1;

            while (lmid >= left && "".equals(input[lmid])) {
                lmid--;
            }

            while (rmid <= right && "".equals(input[rmid])) {
                rmid++;
            }

            if (rmid > right || target.compareTo(input[lmid]) <= 0) {
                right = lmid;
            } else {
                left = rmid;
            }
        }

        return -1;
    }
}
