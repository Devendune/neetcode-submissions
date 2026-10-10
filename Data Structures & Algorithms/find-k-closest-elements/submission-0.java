class Solution 
{
    public List<Integer> findClosestElements(int[] arr, int k, int x) 
    {
        List<Integer> answerList=new ArrayList<>();
        int arraySize=arr.length;
        PriorityQueue<int[]> queue=new PriorityQueue<>(
            (a,b)->{
                if(a[0]!=b[0])
                return Integer.compare(b[0],a[0]);

                
                return Integer.compare(b[1],a[1]);
            });

            for(int element:arr)
            {
                int diff=Math.abs(x-element);
                queue.add(new int[]{diff,element});
                if(queue.size()>k)
                queue.poll();
            }

            while(queue.size()!=0)
            {
                answerList.add(queue.poll()[1]);
            }
            Collections.sort(answerList);
            return answerList;




        

    }
}