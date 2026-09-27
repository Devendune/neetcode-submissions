class Solution 
{
    public boolean isNStraightHand(int[] hand, int groupSize) 
    {
        int handLength=hand.length;
        Map<Integer,Integer>map=new HashMap<>();
        if(handLength%groupSize!=0)
        return false;

        Arrays.sort(hand);
        for(int val:hand)
        map.put(val,1+map.getOrDefault(val,0));

        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            int key=entry.getKey();
            int value=entry.getValue();

            if(value==0)
            continue;

            for(int counter=0;counter<groupSize;counter++)
            {
                int nextValue=map.getOrDefault(key+counter,0);
                if(value<=nextValue)
                map.put(key+counter,nextValue-value);


                else
                return false;
            }
        }
        return true;
    }
}