class Pair
{
    int start;
    int end;

    Pair(int start,int end)
    {
        this.start=start;
        this.end=end;
    }
}
class Solution 
{
    public int[][] merge(int[][] intervals)
    {
        int intervalsLength=intervals.length;
        List<Pair>ansList=new ArrayList<>();

        Arrays.sort(intervals,(a,b)->
        {
        if(a[0]!=b[0])
        return Integer.compare(a[0],b[0]);

        
        else
        return Integer.compare(a[1],b[1]);
        });

        int start=intervals[0][0];
        int end=intervals[0][1];
        int counter=1;

        while(counter<intervals.length && end<intervals[counter][0])
        {
            ansList.add(new Pair(start,end));
        
            start=intervals[counter][0];
            end=intervals[counter][1];
                        counter++;

        }
        for(;counter<intervals.length;counter++)
        {
            int counterValue=intervals[counter][0];
            int counterSecondVal=intervals[counter][1];

            if(end>=counterValue)
            {
                start=Math.min(start,counterValue);
                end=Math.max(end,counterSecondVal);
            }
            else
            {
                ansList.add(new Pair(start,end));
                start=counterValue;
                end=counterSecondVal;
            }
        }
        ansList.add(new Pair(start,end));

        int[][] ans=new int[ansList.size()][2];
        int ansCounter=0;
        for(Pair p:ansList)
        {
            ans[ansCounter][0]=p.start;
            ans[ansCounter][1]=p.end;

            ansCounter++;
        }
        return ans;





        
        /*
        also in the start 1 2 3 4 5 6 can be the case 
        compare the end and starting value if end>start have max and min variables
        to keep updating the min and max
        */
        
    }
}
