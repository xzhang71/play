package leetcode;

/**
 * Created by xzhang71 on 6/10/14.
 */
public class SudokuSolver2 {
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

        SudokuSolver2 ss2 = new SudokuSolver2();
        ss2.solveSudoku(board);

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
            for (char k = '1'; k <= '9'; k++) {
                if (isValid(board, i, j, k)) {
                    board[i][j] = k;
                    if (solveSudokuGo(board, nextI, nextJ)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
            }
            return false;
        } else {
            return solveSudokuGo(board, nextI, nextJ);
        }
    }

    private boolean isValid(char[][] board, int i, int j, char value) {
        for (int k = 0; k < 9; k++) {
            if (value == board[i][k] || value == board[k][j]) {
                return false;
            }
        }

        int x = i - i % 3;
        int y = j - j % 3;
        for (int m = x; m < x + 3; m++) {
            for (int n = y; n < y + 3; n++) {
                if (value == board[m][n]) {
                    return false;
                }
            }
        }

        return true;
    }
}
