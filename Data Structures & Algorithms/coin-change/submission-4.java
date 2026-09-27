class Solution 
{
    public int helper(int[] coins,int coinsLength,int amount,int[][] dp)
    {
        if(amount==0)
        return 0;

        if(coinsLength<=0)
        return Integer.MAX_VALUE-1;

        if(dp[coinsLength][amount]!=-1)
        return dp[coinsLength][amount];

        int value1=Integer.MAX_VALUE;
        if(coins[coinsLength-1]<=amount)
        value1=1+helper(coins,coinsLength,amount-coins[coinsLength-1],dp);

        int value2=helper(coins,coinsLength-1,amount,dp);

        return dp[coinsLength][amount]=Math.min(value1,value2);
    }
    public int coinChange(int[] coins, int amount) 
    {
        int coinsLength=coins.length;
        int[][] dp=new int[coinsLength+1][100001];

        for(int[] arr:dp)
        {
            Arrays.fill(arr,-1);
        }
        int answer=helper(coins,coinsLength,amount,dp);
        if(answer==Integer.MAX_VALUE-1)
        return -1;

        return answer;
    }
}
