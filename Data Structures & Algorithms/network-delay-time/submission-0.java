class Pair
{
    int node;
    int weight;

    Pair(int node,int weight)
    {
        this.node=node;
        this.weight=weight;
    }
}
class Solution 
{
    public int networkDelayTime(int[][] times, int n, int k) 
    {
        int graphLength=times.length;
        int minTime=0;

        List<List<Pair>> adjList=new ArrayList<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(a.weight,b.weight));
        int[] result=new int[n+1];
        Arrays.fill(result,Integer.MAX_VALUE);
        result[k]=0;

        for(int counter=0;counter<n+1;counter++)
        {
            List<Pair>list=new ArrayList<>();
            adjList.add(list);
        }

        for(int counter=0;counter<graphLength;counter++)
        {
            int source=times[counter][0];
            int dest=times[counter][1];
            int weight=times[counter][2];

            adjList.get(source).add(new Pair(dest,weight));
        }

        pq.add(new Pair(k,0));
        while(pq.size()!=0)
        {
            Pair pqTop=pq.poll();
            int currNode=pqTop.node;
            int currDist=pqTop.weight;
            for(Pair p:adjList.get(currNode))
            {
                int newNode=p.node;
                int newDist=p.weight;

                if(currDist+newDist<result[newNode])
                {
                    result[newNode]=currDist+newDist;
                    pq.add(new Pair(newNode,result[newNode]));
                }
            }
        }

        int maxDist=0;
        for(int counter=1;counter<result.length;counter++)
        {
            maxDist=Math.max(maxDist,result[counter]);
        }
        if(maxDist==Integer.MAX_VALUE)
        return -1;

        return maxDist;
    }
}