package cci;

import cci.domain.Color;

/**
 * Created by xzhang71 on 7/19/14.
 */
public class PaintFill {

    public static void paintFill(Color[][] canvas, Color newColor, int x, int y) {
        Color originalColor = new Color(canvas[x][y].val);
        paintFillGo(canvas, originalColor, newColor, x, y);
    }

    private static void paintFillGo(Color[][] canvas, Color originalColor, Color newColor, int x, int y) {
        if (x < 0 || x >= canvas.length || y < 0 || y >= canvas[x].length || canvas[x][y].val != originalColor.val) {
            return;
        }

        canvas[x][y].val = newColor.val;

        paintFillGo(canvas, originalColor, newColor, x - 1, y);
        paintFillGo(canvas, originalColor, newColor, x + 1, y);
        paintFillGo(canvas, originalColor, newColor, x, y - 1);
        paintFillGo(canvas, originalColor, newColor, x, y + 1);
    }

    public static void main(String[] args) {
        Color[][] canvas = new Color[2][3];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = new Color(i * j);
            }
        }

        System.out.println("original canvas");
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                System.out.printf("%3d", canvas[i][j].val);
            }
            System.out.println();
        }
        System.out.println();

        PaintFill.paintFill(canvas, new Color(-1), 0, 0);

        System.out.println("new canvas");
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                System.out.printf("%3d", canvas[i][j].val);
            }
            System.out.println();
        }
        System.out.println();
    }
}
