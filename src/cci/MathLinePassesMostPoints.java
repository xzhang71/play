package cci;

import cci.domain.Line;
import cci.domain.Point;

import java.util.HashMap;

/**
 * Created by xzhang71 on 7/18/14.
 */
public class MathLinePassesMostPoints {

    public static Line find(Point[] points) {
        Line maxLine = null;
        int maxPoints = 0;

        HashMap<String, Integer> cache = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Line line = new Line(points[i], points[j]);
                String key;
                if (line.infiniteSlope) {
                    key = "infinite_" + line.intercept;
                } else {
                    key = line.slope + "_" + line.intercept;
                }

                if (cache.containsKey(key)) {
                    cache.put(key, cache.get(key) + 1);
                } else {
                    cache.put(key, 1);
                }

                if (maxPoints < cache.get(key)) {
                    maxPoints = cache.get(key);
                    maxLine = line;
                }
            }
        }

        return maxLine;
    }

    public static void main(String[] args) {
        Point p0 = new Point(0, 0);
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(0, 1);
        Point p4 = new Point(0, 2);
        Point p5 = new Point(0, 3);

        Point[] points = {p0, p1, p2, p3, p4, p5};
        Line maxLine = MathLinePassesMostPoints.find(points);

        // true, 0.0, 0.0
        System.out.println(maxLine.infiniteSlope);
        System.out.println(maxLine.slope);
        System.out.println(maxLine.intercept);
    }
}
