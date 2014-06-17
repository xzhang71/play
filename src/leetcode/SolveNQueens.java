package leetcode;

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
        if (n < 1) return result;
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        solveNQueensGo(board, 0, new ArrayList<int[]>(), result);
        return result;
    }

    private void solveNQueensGo(char[][] board, int x, List<int[]> queens, List<String[]> result) {
        if (x == board.length) {
            String[] temp = new String[board.length];
            for (int i = 0; i < board.length; i++) {
                temp[i] = String.valueOf(board[i]);
            }
            result.add(temp);
            return;
        }
        for (int y = 0; y < board.length; y++) {
            if (isValidMove(queens, x, y)) {
                int[] pos = {x, y};
                queens.add(pos);
                board[x][y] = 'Q';
                solveNQueensGo(board, x + 1, queens, result);
                board[x][y] = '.';
                queens.remove(queens.size() - 1);
            }
        }
    }

    private boolean isValidMove(List<int[]> queens, int i, int j) {
        for (int[] pos : queens) {
            if (pos[0] == i || pos[1] == j || Math.abs(pos[0] - i) == Math.abs(pos[1] - j)) {
                return false;
            }
        }
        return true;
    }
}
