package cci;

/**
 * Created by xzhang71 on 7/27/14.
 */
public class SubsquareMaximumBlack {

    public static Subsquare findSubsquare(int[][] square) {
        SquareCell[][] processedSquare = getProcessedSquare(square);

        for (int size = processedSquare.length; size >= 1; size--) {
            Subsquare subsquare = findSubsquareWithSize(processedSquare, size);
            if (subsquare != null) {
                return subsquare;
            }
        }

        return null;
    }

    public static SquareCell[][] getProcessedSquare(int[][] square) {
        int n = square.length;
        SquareCell[][] processedSquare = new SquareCell[n][n];

        for (int r = n - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                int zerosRight = 0;
                int zerosBelow = 0;
                if (square[r][c] == 0) {
                    zerosRight++;
                    zerosBelow++;
                    if (c < n - 1) {
                        zerosRight += processedSquare[r][c + 1].zerosRight;
                    }
                    if (r < n - 1) {
                        zerosBelow += processedSquare[r + 1][c].zerosBelow;
                    }
                }
                processedSquare[r][c] = new SquareCell(zerosRight, zerosBelow);
            }
        }

        return processedSquare;
    }

    public static Subsquare findSubsquareWithSize(SquareCell[][] processed, int size) {
        int count = processed.length - size;

        for (int row = 0; row <= count; row++) {
            for (int col = 0; col <= count; col++) {
                if (isValidSubsquare(processed, row, col, size)) {
                    return new Subsquare(row, col, size);
                }
            }
        }

        return null;
    }

    public static boolean isValidSubsquare(SquareCell[][] processed, int row, int col, int squareSize) {
        SquareCell topLeft = processed[row][col];
        SquareCell topRight = processed[row][col + squareSize - 1];
        SquareCell bottomLeft = processed[row + squareSize - 1][col];
        return topLeft.zerosRight >= squareSize && topLeft.zerosBelow >= squareSize && topRight.zerosBelow >= squareSize && bottomLeft.zerosRight >= squareSize;
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