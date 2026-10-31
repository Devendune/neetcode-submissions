class Solution 
{
    List<List<Integer>> ansList=new ArrayList<>();
    void twoSum(int[] nums,int index,int totalSum)
    {
        int endCounter=nums.length-1;

        while(index<endCounter)
        {
            List<Integer> list=new ArrayList<>();
            int currentSum=nums[index]+nums[endCounter];
            if(currentSum==totalSum)
            {
                list.add(-totalSum);
                list.add(nums[index]);
                list.add(nums[endCounter]);
                ansList.add(list);

                int startValue=nums[index];
                int endValue=nums[endCounter];

                while(startValue==nums[index] && index<endCounter)
                index++;

                while(endValue==nums[endCounter] && index<endCounter)
                endCounter--;
            
            }
            else if(currentSum>totalSum)
            endCounter--;

            else
            index++;
        }
    }
    public List<List<Integer>> threeSum(int[] nums) 
    {
        Arrays.sort(nums);
        int numsLength=nums.length;
        for(int counter=0;counter<numsLength;counter++)
        {
            if(counter>0 && nums[counter]==nums[counter-1])
            continue;
            
            twoSum(nums,counter+1,-nums[counter]);
        }
        return ansList;
    }
}