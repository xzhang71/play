package cci.domain;

/**
 * Created by xzhang71 on 7/17/14.
 */
public class Line {

    public static final double epsilon = 0.0001;
    public double slope;
    public boolean infiniteSlope;
    public double intercept;

    public Line(Point p1, Point p2) {
        if (p1.x == p2.x && p1.y == p2.y) {
            throw new RuntimeException("same point");
        }
        if (p1.x == p2.x) {
            infiniteSlope = true;
            intercept = p1.x; // x intercept
        } else {
            slope = calibrate((p2.y - p1.y) / (p2.x - p1.x));
            intercept = calibrate(p1.y - slope * p1.x);
        }
    }

    public double calibrate(double d) {
        return ((int) (d / epsilon)) * epsilon;
    }

    /**
     * Check if two lines intersect
     *
     * @param other
     * @return
     */
    public boolean intersect(Line other) {
        if (infiniteSlope && other.infiniteSlope) {
            return intercept == other.intercept;
        } else if (infiniteSlope || other.infiniteSlope) {
            return false;
        } else {
            return slope != other.slope || (slope == other.slope && intercept == other.intercept);
        }
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(4, 4);

        Line line1 = new Line(p1, p2);
        Line line2 = new Line(p1, p3);
        Line line3 = new Line(p3, p4);

        // false
        System.out.println(line1.intersect(line2));
        // true
        System.out.println(line2.intersect(line3));
        // false
        System.out.println(line3.intersect(line1));
    }
}
