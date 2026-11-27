class Solution 
{
    private boolean isCycle(List<List<Integer>> adjList,int node,boolean[] isVisited,
    boolean[] isRecursion)
    {
        isVisited[node]=true;
        isRecursion[node]=true;

        for(int child:adjList.get(node))
        {
            if(isVisited[child]==true && isRecursion[child]==true)
            return true;

            if(isVisited[child]==false)
            {
                if(isCycle(adjList,child,isVisited,isRecursion))
                return true;
            }
        }
        isRecursion[node]=false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        List<List<Integer>> adjList=new ArrayList<>();
        boolean[] isVisited=new boolean[numCourses];
        boolean[] isRecursion=new boolean[numCourses];

        for(int counter=0;counter<numCourses;counter++)
        {
            List<Integer> list=new ArrayList<>();
            adjList.add(list);
        }

        for(int counter=0;counter<prerequisites.length;counter++)
        {
            int firstVal=prerequisites[counter][0];
            int secondVal=prerequisites[counter][1];

            adjList.get(secondVal).add(firstVal);
        }

        for(int counter=0;counter<numCourses;counter++)
        {
            if(isVisited[counter]==false)
            {
                if(isCycle(adjList,counter,isVisited,isRecursion))
                return false;
            }
        }
        return true;
    }
}