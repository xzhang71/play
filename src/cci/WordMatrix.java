package cci;

import cci.domain.TrieNode;

/**
 * Created by xzhang71 on 7/29/14.
 */
public class WordMatrix {

    public static boolean isValidWordMatrix(char[][] matrix, int row, String[] colGroup, TrieNode rowTrie, StringBuilder cache) {
        for (int c = 0; c < matrix[0].length; c++) {
            for (int r = 0; r < row; r++) {
                cache.append(matrix[r][c]);
            }

            String word = cache.toString();
            if (row == matrix.length) {
                if (!rowTrie.hasWord(word)) {
                    return false;
                }
            } else if (!rowTrie.hasPrefix(word)) {
                return false;
            }
            cache.delete(0, cache.length());
        }

        if (row == matrix.length) {
            return true;
        }

        for (int r = row; r < matrix.length; r++) {
            for (String s : colGroup) {
                matrix[r] = s.toCharArray();
                if (isValidWordMatrix(matrix, row + 1, colGroup, rowTrie, cache)) {
                    return true;
                }
            }
        }

        return false;
    }
}