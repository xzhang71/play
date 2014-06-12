package lee;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xzhang71 on 6/10/14.
 */
public class SudokuSolver {

    public static void main(String[] args) {
        String[] input = {
                "..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..", "...8.3.2.", "........6", "...2759.."
        };

        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = input[i].charAt(j);
            }
        }

        SudokuSolver ss = new SudokuSolver();
        ss.solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }


    public void solveSudoku(char[][] board) {
        if (board == null) {
            // TODO: ERROR!
        } else {
            solveSudokuGo(board, 0, 0);
        }
    }

    private boolean solveSudokuGo(char[][] board, int i, int j) {
        if (i == 9) return true;

        int nextI = i;
        int nextJ = j + 1;
        if (j == 8) {
            nextI = i + 1;
            nextJ = 0;
        }

        if (board[i][j] == '.') {
            char[] answers = getAnswers(board, i, j);
            for (int k = 0; k < answers.length; k++) {
                board[i][j] = answers[k];
                if (solveSudokuGo(board, nextI, nextJ)) {
                    return true;
                }
            }
            board[i][j] = '.';
            return false;
        } else {
            return solveSudokuGo(board, nextI, nextJ);
        }
    }

    private char[] getAnswers(char[][] board, int i, int j) {
        Set<Character> set = new HashSet<>();
        for (char k = '1'; k <= '9'; k++) {
            set.add(k);
        }

        for (int k = 0; k < 9; k++) {
            set.remove(board[i][k]);
            set.remove(board[k][j]);
            if (set.size() == 0) {
                return new char[0];
            }
        }

        int x = i - i % 3;
        int y = j - j % 3;
        for (int m = x; m < x + 3; m++) {
            for (int n = y; n < y + 3; n++) {
                set.remove(board[m][n]);
                if (set.size() == 0) {
                    return new char[0];
                }
            }
        }

        char[] r = new char[set.size()];
        int k = 0;
        for (char c : set) {
            r[k] = c;
            k++;
        }
        return r;
    }
}
