class Solution {
    public int minSubArrayLen(int target, int[] nums) 
    {
        int numsLength=nums.length;
        int firstCounter=0;
        int secondCounter=0;
        int sum=0;
        int minLength=Integer.MAX_VALUE;

        while(secondCounter<numsLength)
        {
            sum+=nums[secondCounter];
            while(sum>=target && firstCounter<=secondCounter)
            {
                minLength=Math.min(minLength,secondCounter-firstCounter+1);
                sum-=nums[firstCounter];
                firstCounter++;
            }
            secondCounter++;
        }
        if(minLength==Integer.MAX_VALUE)
        return 0;


        return minLength;
    }
}