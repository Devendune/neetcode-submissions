class Solution 
{
    private int isShipped(int[] weights,int boatWeight,int days)
    {
        int secondCounter=0,firstCounter=0,currentSum=0,dayCount=0;
        while(secondCounter<weights.length)
        {
            currentSum+=weights[secondCounter];
            if(currentSum>boatWeight)
            {
            currentSum=weights[secondCounter];
            dayCount++;
            }
            secondCounter++;
        }
        return dayCount+1;
    
    }
    public int shipWithinDays(int[] weights, int days) 
    {
        int weightLength=weights.length;
        int minWeight=Integer.MIN_VALUE;
        int maxWeight=0,answer=0;
        for(int weight:weights)
        {
            maxWeight+=weight;
            minWeight=Math.max(minWeight,weight);
        }

        while(minWeight<=maxWeight)
        {
            int midWeight=minWeight+(maxWeight-minWeight)/2;
            System.out.println(midWeight);
            if(isShipped(weights,midWeight,days)<=days)
            {
                answer=midWeight;
                maxWeight=midWeight-1;
            }
            else
            minWeight=midWeight+1;
        }
        return answer;
    }
}