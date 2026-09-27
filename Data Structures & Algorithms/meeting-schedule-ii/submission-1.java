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
    public int minMeetingRooms(List<Interval> intervals) 
    {
        int intervalsLength=intervals.size();
        int countRooms=0;
        int count=0;

        int[] startArr=new int[intervalsLength];
        int[] endArr=new int[intervalsLength];

        for(int counter=0;counter<intervalsLength;counter++)
        {
            startArr[counter]=intervals.get(counter).start;
            endArr[counter]=intervals.get(counter).end;
        }
        Arrays.sort(startArr);
        Arrays.sort(endArr);

        int startCounter=0;
        int endCounter=0;

        while(startCounter<intervalsLength)
        {
            if(startArr[startCounter]<endArr[endCounter])
            {
                startCounter++;
                count++;
            }
            else
            {
                endCounter++;
                count--;
            }
            countRooms=Math.max(countRooms,count);
        }
        return countRooms;
    }
}
