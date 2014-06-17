package leetcode;

import java.util.*;

/**
 * Created by xzhang on 6/13/14.
 */
public class Anagrams {

    public static void main(String[] args) {
        Anagrams a = new Anagrams();
        String[] strs = {"and", "dan"};
        List<String> result = a.anagrams(strs);
        for (String s : result) {
            System.out.println(s);
        }
    }


    // IMPORTANT: make sure you understand what the problem is looking for
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String sorted = sort(strs[i]);
            List<String> list = map.get(sorted);
            if (list == null) {
                list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(sorted, list);
            } else {
                list.add(strs[i]);
            }
        }

        for (List<String> list : map.values()) {
            if(list.size() > 1) {
                result.addAll(list);
            }
        }

        return result;
    }

    public String sort(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
}
