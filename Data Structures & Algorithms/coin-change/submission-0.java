class Solution 
{
    public int helper(int[] coins,int coinsLength,int amount)
    {
        if(amount==0)
        return 0;

        if(coinsLength<=0)
        return Integer.MAX_VALUE-1;

        int value1=Integer.MAX_VALUE;
        if(coins[coinsLength-1]<=amount)
        value1=1+helper(coins,coinsLength,amount-coins[coinsLength-1]);

        int value2=helper(coins,coinsLength-1,amount);

        return Math.min(value1,value2);
    }
    public int coinChange(int[] coins, int amount) 
    {
        int coinsLength=coins.length;
        int answer=helper(coins,coinsLength,amount);

        if(answer==Integer.MAX_VALUE-1)
        return -1;

        return answer;
    }
}
