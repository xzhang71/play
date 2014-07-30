package cci.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhang71 on 7/13/14.
 */
public class TrieNode {
    public boolean isWord = false;
    public Map<Character, TrieNode> children = new HashMap<>();

    public boolean hasWord(String word) {
        char[] charArr = word.toCharArray();
        TrieNode current = this;
        for (char c : charArr) {
            current = current.children.get(c);
            if (current == null) {
                return false;
            }
        }
        return current.isWord;
    }

    public boolean hasPrefix(String s) {
        char[] charArr = s.toCharArray();
        TrieNode current = this;
        for (char c : charArr) {
            current = current.children.get(c);
            if (current == null) {
                return false;
            }
        }
        return true;
    }
}