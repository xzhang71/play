package cci;

import cci.domain.Line;
import cci.domain.Point;

/**
 * Created by xzhang71 on 7/18/14.
 */
public class MathLineCutSquares {

    public static Line cut(Point pa0, Point pa1, Point pb0, Point pb1) {
        return new Line(
                new Point((pa0.x + pa1.x) / 2, (pa0.y + pa1.y) / 2),
                new Point((pb0.x + pb1.x) / 2, (pb0.y + pb1.y) / 2)
        );
    }

    public static void main(String[] args) {
        Point pa0 = new Point(0, 0);
        Point pa1 = new Point(1, 1);
        Point pb0 = new Point(2, 2);
        Point pb1 = new Point(4, 4);

        Line cut = MathLineCutSquares.cut(pa0, pa1, pb0, pb1);
        System.out.println(cut.slope);
        System.out.println(cut.intercept);
    }
}
