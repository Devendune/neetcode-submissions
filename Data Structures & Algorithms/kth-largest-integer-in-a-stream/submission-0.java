class KthLargest 
{
    PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer>queue=new LinkedList<>();
    int value=0;
    int kthValue=0;
    public KthLargest(int k, int[] nums) 
    {
        for(int num:nums)
        pq.offer(num);

        value=k;
        kthValue=k;
    }
    
    public int add(int val) 
    {
        value=kthValue;
        pq.offer(val);
        int answer=0;
        while(pq.size()!=0 && value>0)
        {
            if(value==1)
            answer=pq.peek();

            queue.add(pq.poll());
            value--;
        }
        while(queue.size()!=0)
        pq.offer(queue.poll());

        return answer;
    }
}
