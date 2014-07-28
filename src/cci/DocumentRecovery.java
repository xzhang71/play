package cci;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xzhang71 on 7/25/14.
 */
public class DocumentRecovery {
    public static Document recover(String content, Set<String> dict) {
        return recover(content, 0, dict, new HashMap<Integer, Document>());
    }

    public static Document recover(String content, int index, Set<String> dict, Map<Integer, Document> cache) {
        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        if (index == content.length()) {
            cache.put(index, new Document());
            return cache.get(index);
        }

        Document doc = null;

        for (int i = index + 1; i <= content.length(); i++) {
            String left = content.substring(index, i);
            Document newDoc = recover(content, i, dict, cache);
            int newNum = newDoc.num;
            if (!dict.contains(left)) {
                left = left.toUpperCase();
                newNum += left.length();
            }
            if (doc == null || newNum <= doc.num) {
                if (doc == null) {
                    doc = new Document();
                }
                doc.num = newNum;
                if (newDoc.content.isEmpty()) {
                    doc.content = left;
                } else {
                    doc.content = left + " " + newDoc.content;
                }
            }
        }

        cache.put(index, doc);
        return doc;
    }

    public static void main(String[] args) {
        String content = "jesslookedjustliketimherbrother";
        Set<String> dict = new HashSet<>();
        dict.add("looked");
        dict.add("just");
        dict.add("like");
        dict.add("her");
        dict.add("brother");

        Document recoveredDoc = DocumentRecovery.recover(content, dict);
        System.out.printf("num: %d\ncontent: %s\n", recoveredDoc.num, recoveredDoc.content);
    }
}

class Document {
    public int num = 0;
    public String content = "";
}