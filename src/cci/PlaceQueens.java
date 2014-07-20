package cci;

/**
 * Created by xzhang71 on 7/19/14.
 */
public class PlaceQueens {

    public static void placeQueens(char[][] board) {
        placeQueens(board, 0);
    }

    private static void placeQueens(char[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            return;
        }

        for (int col = 0; col < board[row].length; col++) {
            if (isValidMove(board, row, col)) {
                board[row][col] = 'Q';
                placeQueens(board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isValidMove(char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'Q' && (i == row || j == col || Math.pow(i - row, 2) == Math.pow(j - col, 2))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[8][8];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '.';
            }
        }

        placeQueens(board);
    }
}
