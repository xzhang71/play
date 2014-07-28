package cci;

import cci.domain.TrieNode;

/**
 * Created by xzhang71 on 7/27/14.
 */
public class SubstringSearch {
    public static boolean[] search(String s, String[] strArr) {
        TrieNode root = suffixTree(s);
        boolean[] boolArr = new boolean[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            boolArr[i] = exist(root, strArr[i]);
        }
        return boolArr;
    }

    public static TrieNode suffixTree(String s) {
        TrieNode root = new TrieNode();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            TrieNode current = root;
            for (int j = i; j < charArr.length; j++) {
                if (!current.children.containsKey(charArr[j])) {
                    current.children.put(charArr[j], new TrieNode());
                }
                current = current.children.get(charArr[j]);
            }
        }
        return root;
    }

    public static boolean exist(TrieNode root, String s) {
        char[] charArr = s.toCharArray();
        TrieNode current = root;
        for (char c : charArr) {
            current = current.children.get(c);
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxyz";
        String[] strArr = {"abc", "bbc", "hi", "stud"};
        boolean[] boolArr = SubstringSearch.search(s, strArr);
        for (int i = 0; i < strArr.length; i++) {
            System.out.printf("%s exists %s\n", strArr[i], boolArr[i]);
        }
    }
}
