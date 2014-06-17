package leetcode;

/**
 * Created by xzhang on 6/16/14.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        boolean[][] board2 = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (existGo(board, board2, row, col, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean existGo(char[][] board, boolean[][] board2, int row, int col, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board2[row][col] || word.charAt(index) != board[row][col]) {
            return false;
        }

        board2[row][col] = true;

        int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < moves.length; i++) {
            if (existGo(board, board2, row + moves[i][0], col + moves[i][1], word, index + 1)) {
                return true;
            }
        }

        board2[row][col] = false;

        return false;
    }
}
