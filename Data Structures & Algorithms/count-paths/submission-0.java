class Solution 
{
    public int uniquePath(int x,int y,int m,int n)
    {
        if(x==m-1 && y==n-1)
        return 1;

        if(x>=m || y>=n)
        return 0;

        int right=uniquePath(x,y+1,m,n);
        int down=uniquePath(x+1,y,m,n);

        return right+down;

    }
    public int uniquePaths(int m, int n) 
    {
       return uniquePath(0,0,m,n);      
    }
}
