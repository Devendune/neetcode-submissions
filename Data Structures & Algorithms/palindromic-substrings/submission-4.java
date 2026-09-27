class Solution 
{
    public int isPalindrome(String s,int start,int end,int[][] dp)
    {
        while(start<end)
        {
            if(dp[start][end]!=-1)
            return dp[start][end];

            char startChar=s.charAt(start);
            char endChar=s.charAt(end);
            
            if(startChar==endChar)
            {
                start++;
                end--;
            }
            else
            return dp[start][end]=0;
        }
        return dp[start][end]=1;
    }
    public int countSubstrings(String s) 
    {
        int stringLength=s.length();
        int[][] dp=new int[stringLength+1][stringLength+1];

        for(int[] arr:dp)
        Arrays.fill(arr,-1);

        int ansCount=0;
        for(int counter=0;counter<s.length();counter++)
        {
            for(int secondCounter=counter;secondCounter<s.length();secondCounter++)
            {
                if(isPalindrome(s,counter,secondCounter,dp)==1)
                ansCount++;
            }
        }
        return ansCount;
    }
}
