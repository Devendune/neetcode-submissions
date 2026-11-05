class Solution 
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int rows=matrix.length;
        int cols=matrix[0].length;

        int start=0;
        int end=rows-1;
        int idx=0;

        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(matrix[mid][0]<=target)
            {
                idx=mid;
                start=mid+1;
            }
            else
            end=mid-1;
        }
        start=0;
        end=cols-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(matrix[idx][mid]==target)
            return true;

            else if(matrix[idx][mid]>target)
            end=mid-1;

            else
            start=mid+1;
        }
        return false;
    }
}