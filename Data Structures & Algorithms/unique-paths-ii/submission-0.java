class Solution 
{
    int[][] dp=new int[101][101];
    private int paths(int[][] obstacleGrid,int rowCount,int colCount)
    {
        if(rowCount<0 || rowCount>=obstacleGrid.length || colCount<0 ||
        colCount>=obstacleGrid[0].length)
        return 0;

        if(obstacleGrid[rowCount][colCount]==1)
        return dp[rowCount][colCount]=0;

        if(rowCount==obstacleGrid.length-1 && colCount==obstacleGrid[0].length-1)
        return dp[rowCount][colCount]=1;

        if(dp[rowCount][colCount]!=-1)
        return dp[rowCount][colCount];


        int moveDown=paths(obstacleGrid,rowCount+1,colCount);
        int moveRight=paths(obstacleGrid,rowCount,colCount+1);

        return dp[rowCount][colCount]=moveDown+moveRight;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) 
    {
        int rows=obstacleGrid.length;
        int cols=obstacleGrid[0].length;

        for(int[] currentArr:dp)
        Arrays.fill(currentArr,-1);

        return paths(obstacleGrid,0,0);


    }
}