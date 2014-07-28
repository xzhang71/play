package cci;

/**
 * Created by xzhang71 on 7/27/14.
 */
public class SubsquareMaximumBlack {

    public static Subsquare findSquare(int[][] matrix) {
        SquareCell[][] processed = processSquare(matrix);

        for (int i = processed.length; i >= 1; i--) {
            Subsquare subsquare = findSubsquareWithSize(processed, i);
            if (subsquare != null) {
                return subsquare;
            }
        }

        return null;
    }

    public static SquareCell[][] processSquare(int[][] matrix) {
        SquareCell[][] processed = new SquareCell[matrix.length][matrix.length];

        for (int r = matrix.length - 1; r >= 0; r--) {
            for (int c = matrix.length - 1; c >= 0; c--) {
                int zerosRight = 0;
                int zerosBelow = 0;
                if (matrix[r][c] == 0) {
                    zerosRight++;
                    zerosBelow++;
                    if (c + 1 < matrix.length) {
                        SquareCell previous = processed[r][c + 1];
                        zerosRight += previous.zerosRight;
                    }
                    if (r + 1 < matrix.length) {
                        SquareCell previous = processed[r + 1][c];
                        zerosBelow += previous.zerosBelow;
                    }
                }
                processed[r][c] = new SquareCell(zerosRight, zerosBelow);
            }
        }

        return processed;
    }


    public static Subsquare findSubsquareWithSize(SquareCell[][] processed, int squareSize) {
        int count = processed.length - squareSize;
        for (int row = 0; row <= count; row++) {
            for (int col = 0; col <= count; col++) {
                if (isSubsquare(processed, row, col, squareSize)) {
                    return new Subsquare(row, col, squareSize);
                }
            }
        }
        return null;
    }

    public static boolean isSubsquare(SquareCell[][] processed, int row, int col, int squareSize) {
        SquareCell topLeft = processed[row][col];
        SquareCell topRight = processed[row][col + squareSize - 1];
        SquareCell bottomLeft = processed[row + squareSize - 1][col];

        if (topLeft.zerosRight < squareSize || topLeft.zerosBelow < squareSize || topRight.zerosBelow < squareSize || bottomLeft.zerosRight < squareSize) {
            return false;
        }

        return true;
    }
}

class Subsquare {
    public int row;
    public int col;
    public int size;

    public Subsquare(int row, int col, int size) {
        this.row = row;
        this.col = col;
        this.size = size;
    }
}

class SquareCell {
    public int zerosRight = 0;
    public int zerosBelow = 0;

    public SquareCell(int zerosRight, int zerosBelow) {
        this.zerosRight = zerosRight;
        this.zerosBelow = zerosBelow;
    }
}