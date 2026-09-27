class Solution 
{
    public int helper(int[] nums,int currIndex,int currSum,int target)
    {
        if(currIndex==nums.length)
        {
            if(currSum==target)
            return 1;
        
            return 0;
        }

        int currNegative=helper(nums,currIndex+1,currSum+nums[currIndex],target);
        int currPositive=helper(nums,currIndex+1,currSum-nums[currIndex],target);

        return currNegative+currPositive;
    }

    public int findTargetSumWays(int[] nums, int target) 
    {
        int numsLength=nums.length;
        int totalSum=0;
        for(int val:nums)
        totalSum+=val;

        return helper(nums,0,0,target);
    }
}
