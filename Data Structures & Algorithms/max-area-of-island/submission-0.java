class Solution 
{
    int count=0;
    public void island(int[][] grid,int i,int j)
    {
        if(i>=grid.length || j>=grid[0].length || i<0 || j<0 || grid[i][j]==0 )
        return;

        grid[i][j]=0;
        count++;
        island(grid,i,j+1);
        island(grid,i,j-1);
        island(grid,i+1,j);
        island(grid,i-1,j);
    }
    public int maxAreaOfIsland(int[][] grid) 
    {
        int m=grid.length;
        int n=grid[0].length;
        int maxLength=0;
        for(int counter=0;counter<m;counter++)
        {
            for(int counter2=0;counter2<n;counter2++)
            {
                if(grid[counter][counter2]==1)
                {
                    count=0;
                    island(grid,counter,counter2);
                    maxLength=Math.max(maxLength,count);
                }
            }
        }
        return maxLength;
    }
}