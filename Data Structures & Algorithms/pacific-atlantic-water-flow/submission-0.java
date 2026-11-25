class Solution 
{
    private boolean[][] atlantic;
    private boolean[][] pacific;

    private void dfs(int[][] heights,boolean[][] matrix,int prevHeight,int xCord,int yCord)
    {
        if(xCord<0 || yCord<0 || xCord>=heights.length || yCord>=heights[0].length || prevHeight>heights[xCord][yCord])
        return;

        if(matrix[xCord][yCord])
        return;

        matrix[xCord][yCord]=true;
        dfs(heights,matrix,heights[xCord][yCord],xCord-1,yCord);
        dfs(heights,matrix,heights[xCord][yCord],xCord+1,yCord);
        dfs(heights,matrix,heights[xCord][yCord],xCord,yCord+1);
        dfs(heights,matrix,heights[xCord][yCord],xCord,yCord-1);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        int rows=heights.length;
        int cols=heights[0].length;

        atlantic=new boolean[rows][cols];
        pacific=new boolean[rows][cols];

        for(int counter=0;counter<rows;counter++)
        {
            for(int secondCounter=0;secondCounter<cols;secondCounter++)
            {
                if(counter==0 || secondCounter==0)
                dfs(heights,pacific,-1,counter,secondCounter);

                if(secondCounter==cols-1 || counter==rows-1)
                dfs(heights,atlantic,-1,counter,secondCounter);
            }
        }

        List<List<Integer>>ansList=new ArrayList<>();
        for(int counter=0;counter<rows;counter++)
        {
            for(int secondCounter=0;secondCounter<cols;secondCounter++)
            {
                if(pacific[counter][secondCounter] && atlantic[counter][secondCounter])
                {
                List<Integer>indexes=new ArrayList<>();
                indexes.add(counter);
                indexes.add(secondCounter);
                ansList.add(indexes);
                }
            }
        }
        return ansList;
    }

}