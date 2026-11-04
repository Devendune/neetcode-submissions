class Solution {
    public int searchInsert(int[] nums, int target) 
    {
        int numsLength=nums.length;
        int start=0,mid=0,end=numsLength-1;

        /*
        1 3 5 6 target=0
        0 1 2 3
        */


        while(start<end)
        {
            mid=start+(end-start)/2;
            if(nums[mid]==target)
            return mid;

            else if(nums[mid]<target)
            start=mid+1;

            else
            end=mid-1;
        }
        if(nums[start]<target)
        return start+1;
        
        return start;

    }
}