class Solution 
{
    private int canSplit(int[] nums,int totalSum,int k)
    {
        int currentSum=0,secondCounter=0,totalCount=0;
        while(secondCounter<nums.length)
        {
            currentSum+=nums[secondCounter];
            if(currentSum>totalSum)
            {
                currentSum=nums[secondCounter];
                totalCount++;
            }
            secondCounter++;
        }
        return totalCount+1;
    }
    public int splitArray(int[] nums, int k) 
    {
        int minSum=0,maxSum=0,answer=0;

        for(int num:nums)
        {
        maxSum+=num;
        minSum=Math.max(num,minSum);
        }

        while(minSum<=maxSum)
        {
            int midSum=minSum+(maxSum-minSum)/2;
            if(canSplit(nums,midSum,k)<=k)
            {
                answer=midSum;
                maxSum=midSum-1;
            }
            else
            {
                minSum=midSum+1;
            }
        }
        return answer;
    }
}