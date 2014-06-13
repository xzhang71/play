package lee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhang on 6/13/14.
 */
public class SolveNQueens {

    public static void main(String[] args) {
        SolveNQueens snq = new SolveNQueens();
        List<String[]> result = snq.solveNQueens(9);
        for (String[] strArr : result) {
            for (String str : strArr) {
                System.out.println(str);
            }
            System.out.println();
        }
    }

    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }

        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '.';
            }
        }
        solveNQueensGo(board, 0, 0, 0, result);

        return result;
    }

    private void solveNQueensGo(char[][] board, int x, int y, int queens, List<String[]> result) {
        if (queens == board.length) {
            String[] temp = new String[board.length];
            for (int k = 0; k < board.length; k++) {
                temp[k] = String.valueOf(board[k]);
            }
            result.add(temp);
            return;
        }

        int i = x;
        while (i < board.length) {
            int j = i == x ? y : 0;
            while (j < board[i].length) {
                if (isValidMove(board, i, j)) {
                    board[i][j] = 'Q';
                    solveNQueensGo(board, i, j, queens + 1, result);
                    board[i][j] = '.';
                }
                j++;
            }
            i++;
        }
    }

    private boolean isValidMove(char[][] board, int x, int y) {
        if (board[x][y] == 'Q') {
            return false;
        }

        for (int j = 0; j < y; j++) {
            if (board[x][j] == 'Q') {
                return false;
            }
        }

        for (int i = 0; i < x; i++) {
            if (board[i][y] == 'Q') {
                return false;
            }
        }

        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = x - 1, j = y + 1; i >= 0 && j < board[i].length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = x + 1, j = y - 1; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
