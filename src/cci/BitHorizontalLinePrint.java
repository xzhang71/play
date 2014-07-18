package cci;

/**
 * Created by xzhang71 on 7/17/14.
 */
public class BitHorizontalLinePrint {

    public static void print(byte[] screen, int width, int x0, int x1, int y) {
        int lineOffSet = width / 8 * y;

        for (int i = x0 / 8; i <= x1 / 8; i++) {
            screen[lineOffSet + i] = (byte) 0xFF;
        }

        screen[lineOffSet + x0 / 8] &= 0xFF >> (x0 % 8);
        screen[lineOffSet + x1 / 8] &= 0xFF << (8 - (x1 % 8 + 1));
    }

    private static void printScreen(byte[] screen, int width) {
        for (int i = 0; i < screen.length; i++) {
            if (i % (width / 8) == 0) {
                System.out.println();
            }
            for (int j = 0x80; j != 0; j >>= 1) {
                if ((screen[i] & j) == 0) {
                    System.out.print(0);
                } else {
                    System.out.print(1);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        byte[] screen = new byte[16];
        int width = 16;

        printScreen(screen, width);

        BitHorizontalLinePrint.print(screen, width, 3, 8, 4);

        printScreen(screen, width);
    }
}
