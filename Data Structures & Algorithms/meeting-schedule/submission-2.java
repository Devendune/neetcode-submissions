/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) 
    {
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
        if(intervals.size()==0)
        return true;

        int value=intervals.get(0).end;
        for(int counter=1;counter<intervals.size();counter++)
        {
            if(value>intervals.get(counter).start)
            return false;

            value=intervals.get(counter).end;
        }
        return true;
    }
}
