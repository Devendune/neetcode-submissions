class Solution 
{
    int[][] dp=new int[301][100000];
    private int solve(int[] coins,int index,int currSum,int amount)
    {
        if(currSum==amount)
        return 1;

        if(index>=coins.length || currSum>amount)
        return 0;   

        if(dp[index][currSum]!=-1)
        return dp[index][currSum];     

        int take=0,notTake=0;
        if(coins[index]<=amount)
        take=solve(coins,index,currSum+coins[index],amount);

        notTake=solve(coins,index+1,currSum,amount);

        return dp[index][currSum]=take+notTake;
    }
    public int change(int amount, int[] coins) 
    {
        for(int[] arr:dp)
        Arrays.fill(arr,-1);

        return solve(coins,0,0,amount);
    }
}