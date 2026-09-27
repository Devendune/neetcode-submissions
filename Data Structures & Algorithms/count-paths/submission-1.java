class Solution 
{
    public int uniquePath(int x,int y,int m,int n,int[][] dp)
    {
        if(x==m-1 && y==n-1)
        return 1;

        if(x>=m || y>=n)
        return 0;

        if(dp[x][y]!=-1)
        return dp[x][y];

        int right=uniquePath(x,y+1,m,n,dp);
        int down=uniquePath(x+1,y,m,n,dp);

        return dp[x][y]=right+down;

    }
    public int uniquePaths(int m, int n) 
    {
     int [][]dp=new int[m+1][n+1];

     for(int[] arr:dp)
     {
        Arrays.fill(arr,-1);
     }
       return uniquePath(0,0,m,n,dp);      
    }
}
