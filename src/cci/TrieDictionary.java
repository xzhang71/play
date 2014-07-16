package cci;

import cci.domain.TrieNode;

/**
 * Created by xzhang71 on 7/15/14.
 */
public class TrieDictionary {

    public static TrieNode createDictionary(String[] words) {
        TrieNode dict = new TrieNode();

        for (String word : words) {
            TrieNode current = dict;
            for (char c : word.toLowerCase().toCharArray()) {
                TrieNode child = current.children.get(c);
                if (child == null) {
                    child = new TrieNode();
                    current.children.put(c, child);
                }
                current = child;
            }
            current.isWord = true;
        }

        return dict;
    }

    public static boolean isWord(TrieNode dict, String word) {
        TrieNode current = dict;
        for (char c : word.toLowerCase().toCharArray()) {
            current = current.children.get(c);
            if (current == null) {
                return false;
            }
        }
        return current.isWord;
    }

    public static void main(String[] args) {
        String[] words = {"Check", "if", "a", "tree", "is", "balanced"};
        TrieNode dict = TrieDictionary.createDictionary(words);
        System.out.println("Real words:");
        for (String word : words) {
            System.out.println(TrieDictionary.isWord(dict, word));
        }

        String[] nonWords = {"heck", "f", "", "ree", "s", "alanced"};
        System.out.println("Fake words");
        for (String word : nonWords) {
            System.out.println(TrieDictionary.isWord(dict, word));
        }
    }
}
