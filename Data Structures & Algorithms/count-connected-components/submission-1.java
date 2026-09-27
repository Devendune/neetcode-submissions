class Solution 
{
    private void dfs( List<List<Integer>>adjList,int vertex,boolean[] visited)
    {
        visited[vertex]=true;
        for(int val:adjList.get(vertex))
        {
            if(visited[val]==false)
            dfs(adjList,val,visited);
        }
    }
    public int countComponents(int n, int[][] edges) 
    {
        List<List<Integer>>adjList=new ArrayList<>();
        for(int counter=0;counter<n;counter++)
        {
            List<Integer>list=new ArrayList<>();
            adjList.add(list);
        }

        for(int[] edge:edges)
        {
            int u=edge[0];
            int v=edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);

        }

        boolean[] visited=new boolean[n];
        int countComponents=0;
        for(int counter=0;counter<n;counter++)
        {
            if(visited[counter]==false)
            {
            dfs(adjList,counter,visited);
            countComponents++;
            }
        }
        return countComponents;
    }
}
