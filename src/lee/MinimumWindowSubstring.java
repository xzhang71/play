package lee;

/**
 * Created by xzhang on 6/16/14.
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        String s = "";
        String t = "ABC";
        System.out.println("\"" + mws.minWindow(s, t) + "\"");
    }

    public String minWindow(String S, String T) {
        int head = 0;
        int tail = 0;

        int[] found = new int[256];
        int[] toFind = new int[256];

        for (int i = 0; i < T.length(); i++) {
            toFind[T.charAt(i)] += 1;
        }

        int minLength = Integer.MAX_VALUE;
        int minHead = -1;
        int minTail = -1;
        int numOfFound = 0;

        while (tail < S.length()) {
            char current = S.charAt(tail);

            // element not in toFind, skip
            if (toFind[current] == 0) {
                tail++;
                continue;
            }

            // found is less than toFind, increment numOfFound
            if (found[current] < toFind[current]) {
                numOfFound++;
            }
            found[current] += 1;

            // all characters found
            if (numOfFound == T.length()) {
                while (toFind[S.charAt(head)] == 0 || found[S.charAt(head)] > toFind[S.charAt(head)]) {
                    found[S.charAt(head)] -= 1;
                    head++;
                }
                if (minLength > tail - head) {
                    minLength = tail - head + 1;
                    minHead = head;
                    minTail = tail;
                }
            }

            tail++;
        }

        if (minHead == -1) {
            return "";
        } else {
            return S.substring(minHead, minTail + 1);
        }
    }
}
