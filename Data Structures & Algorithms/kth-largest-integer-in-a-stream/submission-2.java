class KthLargest 
{
    PriorityQueue<Integer>pq=new PriorityQueue<>();
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
        pq.add(val);
        while(pq.size()>value)
        {
            pq.poll();
        }
        return pq.peek();
    }
}
