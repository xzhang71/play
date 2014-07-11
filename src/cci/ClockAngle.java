package cci;

/**
 * Given a time, calculate the angle from the hour to minute hands
 * <p/>
 * Created by xzhang on 7/10/14.
 */
public class ClockAngle {

    /*
    public static double angle(long timestamp) {
        int divisor = 1000 * 60;
        int second = timestamp % divisor;
        divisor *= 60;
        int minute = timestamp % divisor;
        divisor *= 12;
        int hour = timestamp % divisor;

        angleOfHour = (1.0 * hour / 12 + 1.0 * minute / 60 / 12 + 1.0 * second / 60 / 60 / 12) * 360;
        angleOfMinute = (1.0 * minute / 60 + 1.0 * second / 60 / 60) * 360;
        return angleOfMinute - angleOfHour;
    }
    */

    public static double angle(long timestamp) {
        long second = timestamp / 1000;
        int secondHand = (int) (second % 60);
        long minute = (int) (second / 60);
        int minuteHand = (int) (minute % 60);
        long hour = minute / 60;
        int hourHand = (int) (hour % 12);

        double angleOfHour = (360.0 / 12) * (hourHand + minuteHand / 60 + secondHand / 3600);
        double angleOfMinute = (360.0 / 60) * (minuteHand + secondHand / 60);

        return angleOfMinute - angleOfHour;
    }

    public static void main(String[] args) {
        long t = 1404997200000l;
        System.out.println(ClockAngle.angle(t));
    }
}
