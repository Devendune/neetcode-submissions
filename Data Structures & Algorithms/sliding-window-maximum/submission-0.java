class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        List<Integer> list=new ArrayList<>();
        int startCounter=0,endCounter=0,ansCounter=0;
        TreeMap<Integer,Integer> map=new TreeMap<>(Collections.reverseOrder());

        while(endCounter<nums.length)
        {
            while(endCounter-startCounter+1<=k)
            {
                int number=nums[endCounter];
                map.put(number,1+map.getOrDefault(number,0));
                endCounter++;
            }
            list.add(map.firstKey());
            if(map.get(nums[startCounter])!=null)
            {
                if(map.get(nums[startCounter])>1)
                map.put(nums[startCounter],map.get(nums[startCounter])-1);

                else
                map.remove(nums[startCounter]);
            }

            startCounter++;
        }
        int arr[]=new int[list.size()];
        int counter=0;
        for(int element:list)
        {
            arr[counter]=element;
            counter++;
        } 
        return arr;
    }
}
