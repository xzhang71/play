package cci;

import cci.domain.TrieNode;

/**
 * Created by xzhang71 on 7/13/14.
 */
public class SubstringCheck {

    /**
     * Write code to check if one word is substring of another.
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isSubstring(String str1, String str2) {
        if (str1 == null || str2 == null || str2.length() > str1.length()) {
            return false;
        }

        TrieNode root = new TrieNode();

        for (int i = 0; i < str1.length(); i++) {
            TrieNode current = root;
            for (int j = i; j < str1.length(); j++) {
                char c = str1.charAt(j);
                TrieNode child = current.children.get(c);
                if (child == null) {
                    child = new TrieNode();
                    current.children.put(c, child);
                }
                current = child;
            }
        }

        TrieNode current = root;
        for (int i = 0; i < str2.length(); i++) {
            current = current.children.get(str2.charAt(i));
            if (current == null) {
                return false;
            }
        }

        return true;
    }

    /**
     * Write code to check if one word is substring of another.
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isSubstring2(String str1, String str2) {
        if (str1 == null || str2 == null || str2.length() > str1.length()) {
            return false;
        }

        // IMPORTANT: i <= str1.length() - str2.length()
        for (int i = 0; i <= str1.length() - str2.length(); i++) {
            // IMPORTANT: str2.length() + i
            if (str1.substring(i, str2.length() + i).equals(str2)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String[] tests = new String[]{"", "ab", "bc", "cd", "abc", "bcd", "abcba"};

        for (String t : tests) {
            System.out.println(SubstringCheck.isSubstring("abcba", t));
        }

        System.out.println();
        for (String t : tests) {
            System.out.println(SubstringCheck.isSubstring2("abcba", t));
        }
    }
}
