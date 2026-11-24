class Solution {
    public int findJudge(int n, int[][] trust) 
    {
        int indegree[]=new int[n+1];
        int outdegree[]=new int[n+1];
        for(int[] node:trust)
        {
            outdegree[node[0]]++;
            indegree[node[1]]++;
        }

        int answer=-1;
        boolean flag=false;
        for(int counter=1;counter<n+1;counter++)
        {
           if(outdegree[counter]==0 && indegree[counter]==n-1)
           return counter;
        }
        return -1;
     
    }
}