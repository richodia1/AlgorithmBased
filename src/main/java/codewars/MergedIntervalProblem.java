package codewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/*
Given a list of intervals, merge all the overlapping intervals to produce a list that has only
mutually exclusive intervals.
Example 1:
Intervals: [[1,4], [2,5], [7,9]]
Output: [[1,5], [7,9]]
Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
one [1,5].

 */
public class MergedIntervalProblem {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    };
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;

        // sort the intervals by start time
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedIntervals = new LinkedList<Interval>();
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next();
        int start = interval.start;
        int end = interval.end;

        while (intervalItr.hasNext()) {
            interval = intervalItr.next();
            if (interval.start <= end) { // overlapping intervals, adjust the 'end'
                end = Math.max(interval.end, end);
            }
            else { // non-overlapping interval, add the previous interval and reset
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        // add the last interval
        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }
    public static List<Interval> merge2(List<Interval> intervals) {
        if(intervals.size() < 2) return intervals;
        Collections.sort(intervals,(a,b) ->Integer.compare(a.start,b.start));
        List<Interval> merged = new LinkedList<>();
        Iterator<Interval> itr = intervals.iterator();
        Interval intV = itr.next();
        int start = intV.start;
        int end = intV.end;
        while (itr.hasNext()){
            Interval interval = itr.next();
            if(interval.start <= end){
                end = Math.max(end,interval.end);
            }else {
                merged.add(new Interval(start,end));
                end = interval.end;
                start = interval.start;
            }
        }
        merged.add(new Interval(start,end));
        return merged;
    }
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }


}
