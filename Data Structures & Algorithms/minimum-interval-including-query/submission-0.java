class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) 
    {
        for(int counter=0;counter<queries.length;counter++)
        {
            int ans=Integer.MAX_VALUE;
            int queryValue=queries[counter];
            for(int[] interval:intervals)
            {
                int firstVal=interval[0];
                int secondVal=interval[1];

                if(queryValue>= firstVal && queryValue<=secondVal)
                ans=Math.min(secondVal-firstVal+1,ans);
            }
            if(ans==Integer.MAX_VALUE)
            ans=-1;

            queries[counter]=ans;
        }
        return queries;
    }
}
