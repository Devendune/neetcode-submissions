class Solution 
{
    private void reverse(int[] nums,int startCounter,int endCounter)
    {
        while(startCounter<endCounter)
        {
            int temp=nums[startCounter];
            nums[startCounter]=nums[endCounter];
            nums[endCounter]=temp;

            startCounter++;
            endCounter--;
        }
    }
    public void rotate(int[] nums, int k) 
    {    
        int endCounter=nums.length;
        k=k%nums.length;
        reverse(nums,0,endCounter-1);
        reverse(nums,0,k-1);
        reverse(nums,k,endCounter-1);
    }
}