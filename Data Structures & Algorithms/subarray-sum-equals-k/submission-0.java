class Solution {
    public int subarraySum(int[] nums, int k) 
    {
        int numsLength=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);

        int sum=0;
        int count=0;
        for(int num:nums)
        {
            sum+=num;
            if(map.containsKey(sum-k))
            count+=map.get(sum-k);

            
            map.put(sum,1+map.getOrDefault(sum,0));
        }
        return count;
    }
}