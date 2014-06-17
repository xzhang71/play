package leetcode;

import leetcode.domain.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xzhang71 on 6/14/14.
 */
// TODO: FIND THE BUG
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> resultList = new ArrayList<>();
        if (intervals == null) {
            return resultList;
        }

        if (intervals.size() <= 1) {
            return intervals;
        }

        Comparator<Interval> intervalComp = new Comparator<Interval>() {
            @Override
            public int compare(Interval obj1, Interval obj2) {
                if (obj1.start == obj2.start) {
                    return obj1.end - obj2.end;
                } else {
                    return obj1.start - obj2.start;
                }
            }
        };

        Collections.sort(intervals, intervalComp);

        Interval prev = intervals.get(0);
        for (Interval current : intervals) {
            if (prev.end >= current.start) {
                prev.end = Math.max(prev.end, current.end);
            } else {
                resultList.add(prev);
                prev = current;
            }
        }

        return resultList;
    }
}