package leetcode;

import leetcode.domain.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhang71 on 6/14/14.
 */

// TODO: FIND THE BUG
public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null) {
            // TODO: ERROR?
            return null;
        }

        boolean isAdded = false;
        List<Interval> resultList = new ArrayList<>();
        for (Interval current : intervals) {
            if (isAdded) {
                resultList.add(current);
            } else {
                if (newInterval.end < current.start) {
                    resultList.add(newInterval);
                    resultList.add(current);
                    isAdded = true;
                } else if (newInterval.start <= current.end) {
                    newInterval.start = Math.min(newInterval.start, current.start);
                    newInterval.end = Math.max(newInterval.end, current.end);
                } else {
                    resultList.add(current);
                }
            }
        }

        return resultList;
    }
}
