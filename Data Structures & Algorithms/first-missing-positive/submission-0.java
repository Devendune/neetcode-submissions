class Solution 
{
    private void swap(int[] nums,int firstCounter,int secondCounter)
    {
        int temp=nums[firstCounter];
        nums[firstCounter]=nums[secondCounter];
        nums[secondCounter]=temp;
    }
    public int firstMissingPositive(int[] nums) 
    {
        int numsLength=nums.length;
       for(int counter=0;counter<nums.length;counter++)
       {
        while(nums[counter]>0 && nums[counter]<=numsLength && nums[counter]!=nums[nums[counter]-1])
        swap(nums,counter,nums[counter]-1);
       }
       for(int counter=0;counter<numsLength;counter++)
       {
        if(counter+1!=nums[counter])
        return counter+1;
       }
       return numsLength+1;
    }
}