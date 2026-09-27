class Solution {
    public int longestConsecutive(int[] nums) 
    {
        //2 3 4 4 5 10 20
        TreeMap<Integer,Integer>map=new TreeMap<>();
        for(int num:nums)
        map.put(num,1+map.getOrDefault(num,0));

        int count=1;
        int longestCount=0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet())
        {
            int mapKey=entry.getKey();
            int mapValue=entry.getValue();

            if(map.containsKey(mapKey+1))
            count++;

            else
            count=1;

            longestCount=Math.max(longestCount,count);
        }
        return longestCount;
    }
}
