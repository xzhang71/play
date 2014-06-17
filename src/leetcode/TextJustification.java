package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhang71 on 6/15/14.
 */

// TODO: REFACTOR

public class TextJustification {

    public List<String> fullJustify(String[] words, int L) {
        List<String> resultList = new ArrayList<>();
        if (words == null) {
            return resultList;
        }

        List<String> tempList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() != 0) {
                tempList.add(words[i]);
            }
        }
        words = new String[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            words[i] = tempList.get(i);
        }

        if (words.length == 0) {
            StringBuilder sb = new StringBuilder("");
            while (sb.length() < L) {
                sb.append(" ");
            }
            resultList.add(sb.toString());
            return resultList;
        }

        int start = 0, end = 0, currentL = words[0].length();
        for (int i = 1; i < words.length; i++) {
            if (currentL + 1 + words[i].length() > L) {
                resultList.add(produceLine(words, start, end, currentL, L));
                start = i;
                end = i;
                currentL = words[i].length();
            } else {
                currentL += 1 + words[i].length();
                end = i;
            }
        }

        resultList.add(produceLastLine(words, start, end, L));

        return resultList;
    }

    public String produceLine(String[] words, int start, int end, int currentL, int L) {
        StringBuilder sb = new StringBuilder("");
        if (start == end) {
            sb.append(words[start]);
            for (int i = 1; i <= L - currentL; i++) {
                sb.append(" ");
            }
        } else {
            int m = (L - currentL) / (end - start);
            int n = (L - currentL) % (end - start);
            String spaces = "";
            for (int i = 1; i <= m; i++) {
                spaces += " ";
            }
            for (int i = start; i < end; i++) {
                sb.append(words[i]);
                sb.append(" ");
                sb.append(spaces);
                if (n > 0) {
                    sb.append(" ");
                    n--;
                }
            }
            sb.append(words[end]);
        }

        return sb.toString();
    }

    public String produceLastLine(String[] words, int start, int end, int L) {
        StringBuilder sb = new StringBuilder("");
        for (int i = start; i < end; i++) {
            sb.append(words[i]);
            sb.append(" ");
        }
        sb.append(words[end]);

        while (sb.length() < L) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
