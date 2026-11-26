class Solution 
{
    int[][] dp=new int[102][102];
    private int amount(int[] nums,int index,int endIndex)
    {
        if(dp[index][endIndex]!=-1)
        return dp[index][endIndex];

        if(index>endIndex)
        return dp[index][endIndex]=0;

        int robHouse=nums[index]+amount(nums,index+2,endIndex);
        int skipHouse=amount(nums,index+1,endIndex);

        return dp[index][endIndex]=Math.max(robHouse,skipHouse);
    }
    public int rob(int[] nums) 
    {
        for(int[] dpArr:dp)
        Arrays.fill(dpArr,-1);

        if(nums.length==1)
        return nums[0];

        int excludeLast=amount(nums,0,nums.length-2);
        int includeLast=amount(nums,1,nums.length-1);
        return Math.max(includeLast,excludeLast);
    }
}