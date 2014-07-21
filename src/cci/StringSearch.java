package cci;

/**
 * Created by xzhang71 on 7/20/14.
 */
public class StringSearch {

    public static int binarySearch(String[] input, String val) {
        int l = 0;
        int r = input.length - 1;

        while (l <= r) {
            if (l == r) {
                if (input[l].equals(val)) {
                    return l;
                } else {
                    return -1;
                }
            }

            int lmid = (l + r) / 2;
            int rmid = lmid + 1;

            while (l < lmid && input[lmid].equals("")) {
                lmid--;
            }

            while (rmid < r && input[rmid].equals("")) {
                rmid++;
            }

            if (input[lmid].equals("")) {
                l = rmid;
            } else if (input[rmid].equals("")) {
                r = lmid;
            } else {
                if (val.compareTo(input[lmid]) <= 0) {
                    r = lmid;
                } else {
                    l = rmid;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] input = {"", "", "at", "", "", "ball", "", "", "", "car", "", "", "", "", "dad", "", ""};

        System.out.println(StringSearch.binarySearch(input, "at"));
        System.out.println(StringSearch.binarySearch(input, "ball"));
        System.out.println(StringSearch.binarySearch(input, "car"));
        System.out.println(StringSearch.binarySearch(input, "dad"));
        System.out.println(StringSearch.binarySearch(input, "egg"));
    }
}
