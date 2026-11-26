class Solution 
{
    int arr[]=new int[102];
    public int rob(int[] nums,int counter)
    {
        if(counter>=nums.length)
        return arr[counter]=0;

        if(arr[counter]!=-1)
        return arr[counter];

        int include=nums[counter]+rob(nums,counter+2);
        int exclude=rob(nums,counter+1);

        return arr[counter]=Math.max(include,exclude);
    }
    public int rob(int[] nums) 
    {
        Arrays.fill(arr,-1);
        return rob(nums,0);
    }
}