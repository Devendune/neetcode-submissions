class Solution 
{
    private boolean isCycleDetected(List<List<Integer>>adjList,int parent,int child,boolean[] visited)
    {
        visited[child]=true;
        for(int counter=0;counter<adjList.get(child).size();counter++)
        {
            //child=0 value=1
            int nextChild=adjList.get(child).get(counter);
            if(visited[nextChild]==false)
            {
                if(isCycleDetected(adjList,child,nextChild,visited)==true)
                return true;
            }
            else
            {
                if(nextChild!=parent)
                return true;
            }
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) 
    {
        List<List<Integer>>adjList=new ArrayList<>();
        for(int counter=0;counter<n;counter++)
        {
            List<Integer>list=new ArrayList<>();
            adjList.add(list);
        }
        for(int[] edge:edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean visited[]=new boolean[n];
        int countComponents=0;
        for(int counter=0;counter<n;counter++)
        {
            if(visited[counter]==false)
            {
                if(isCycleDetected(adjList,-1,counter,visited)==true)
                return false;

                countComponents++;
            }
        }
        if(countComponents>1)
        return false;

        return true;


    }
}
