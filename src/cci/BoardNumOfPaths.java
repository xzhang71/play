package cci;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhang71 on 7/18/14.
 */
public class BoardNumOfPaths {

    public static int numOfPaths(char[][] board) {
        return numOfPathsGo(board, 0, 0, new HashMap<String, Integer>());
    }

    private static int numOfPathsGo(char[][] board, int x, int y, Map<String, Integer> cache) {
        if (x >= board.length || y >= board[x].length || board[x][y] == 'X') {
            return 0;
        }

        if (x == board.length - 1 && y == board[x].length - 1) {
            return 1;
        }

        String key = x + "_" + y;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int numOfPaths = numOfPathsGo(board, x + 1, y, cache) + numOfPathsGo(board, x, y + 1, cache);
        cache.put(key, numOfPaths);

        return numOfPaths;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.'},
                {'.', '.', 'X', 'X'},
                {'.', '.', '.', '.'}
        };

        // 2
        System.out.println(BoardNumOfPaths.numOfPaths(board));
    }
}
