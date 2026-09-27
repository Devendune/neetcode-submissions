class Solution 
{
    public int interleave(String s1,String s2,String s3,int firstCounter,
    int secondCounter,int thirdCounter,int[][] dp)
    {
        if(thirdCounter==s3.length())
        {
            if(firstCounter==s1.length() && secondCounter==s2.length())
            return 1;

            else
            return 0;
        }

        if(dp[firstCounter][secondCounter]!=-1)
        return dp[firstCounter][secondCounter];

        if(firstCounter<s1.length() && secondCounter<s2.length())
        {
            if(s1.charAt(firstCounter)==s3.charAt(thirdCounter) &&
            s2.charAt(secondCounter)==s3.charAt(thirdCounter))
            {
                int takeS1=interleave(s1,s2,s3,firstCounter+1,secondCounter,thirdCounter+1,dp);
                int takeS2=interleave(s1,s2,s3,firstCounter,secondCounter+1,thirdCounter+1,dp);

                if(takeS1==1 || takeS2==1)
                dp[firstCounter][secondCounter]=1;

                else
                dp[firstCounter][secondCounter]=0;

                return dp[firstCounter][secondCounter];
            }
            else if(!(s1.charAt(firstCounter)==s3.charAt(thirdCounter) ||
            s2.charAt(secondCounter)==s3.charAt(thirdCounter)))
            return dp[firstCounter][secondCounter]=0;
        }
        if(firstCounter<s1.length())
        if(s1.charAt(firstCounter)==s3.charAt(thirdCounter))
            return dp[firstCounter][secondCounter]=interleave(s1,s2,s3,firstCounter+1,secondCounter,
            thirdCounter+1,dp);
        
        if(secondCounter<s2.length())
        if(s2.charAt(secondCounter)==s3.charAt(thirdCounter))
         return dp[firstCounter][secondCounter]=interleave(s1,s2,s3,firstCounter,secondCounter+1,
            thirdCounter+1,dp);
        

        return dp[firstCounter][secondCounter]=0;
    }

    public boolean isInterleave(String s1, String s2, String s3) 
    {
        int firstStringLength=s1.length();
        int secondStringLength=s2.length();
        int thirdStringLength=s3.length();

        int dp[][]=new int[firstStringLength+1][secondStringLength+1];

        for(int[] arr:dp)
        Arrays.fill(arr,-1);

        if(firstStringLength+secondStringLength!=thirdStringLength)
        return false;

        return (interleave(s1, s2, s3, 0, 0, 0, dp) == 0) ? false : true;

    }
}
