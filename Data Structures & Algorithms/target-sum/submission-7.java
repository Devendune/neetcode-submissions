class Solution 
{
    int[][] dp=new int[31][20001];
    int offset;
    private int calculateSum(int[] nums,int currentSum,int index,int target)
    {
        if(index==nums.length)
        {
            if(currentSum==target)
            return 1;

            return 0;
        }

        if(dp[index][currentSum+offset]!=-1)
        return dp[index][currentSum+offset];

        int positiveNumber=calculateSum(nums,currentSum+nums[index],index+1,target);
        int negativeNumber=calculateSum(nums,currentSum-nums[index],index+1,target);

        return dp[index][currentSum+offset]=positiveNumber+negativeNumber;
    }
    public int findTargetSumWays(int[] nums, int target) 
    {
        int total=0;
        for(int num:nums)
        total+=num;

        offset=total;

        for(int[] arr:dp)
        Arrays.fill(arr,-1);

        int numsLength=nums.length;
        return calculateSum(nums,0,0,target);
    }
}