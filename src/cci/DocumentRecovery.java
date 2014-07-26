package cci;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xzhang71 on 7/25/14.
 */
public class DocumentRecovery {
    public static String recover(String content, Set<String> dict) {
        Document doc = recover(content, dict, 0, new HashMap<Integer, Document>());
        return doc.content;
    }

    public static Document recover(String content, Set<String> dict, int index, Map<Integer, Document> cache) {
        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        if (index >= content.length()) {
            cache.put(index, new Document());
            return cache.get(index);
        }

        Document doc = null;

        int i = index + 1;
        while (i <= content.length()) {
            Document newDoc = recover(content, dict, i, cache);

            String current = content.substring(index, i);
            int newNum = newDoc.num;

            if (!dict.contains(current)) {
                current = current.toUpperCase();
                newNum += current.length();
            }

            if (doc == null || newNum <= doc.num) {
                if (doc == null) {
                    doc = new Document();
                }
                doc.num = newNum;
                doc.content = current + ' ' + newDoc.content;
            }

            i++;
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

        String newContent = DocumentRecovery.recover(content, dict);
        System.out.println(newContent);
    }
}

class Document {
    public int num = 0;
    public String content = "";
}