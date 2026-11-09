class Solution 
{
    private int searchAscending(int start, int end, int target, MountainArray mountainArr)
    {
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            int val = mountainArr.get(mid);

            if (val == target) return mid;
            else if (val > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    // descending side
    private int searchDescending(int start, int end, int target, MountainArray mountainArr)
    {
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            int val = mountainArr.get(mid);

            if (val == target) return mid;
            else if (val > target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    private int findPeak(MountainArray mountainArr)
    {
        int start = 0, end = mountainArr.length() - 1;
        while (start < end)
        {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1))
                start = mid + 1;   
            else
                end = mid;         // descending (or at peak), peak is at mid or left
        }
        return start;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) 
    {
        int peakIndex = findPeak(mountainArr);

        int left = searchAscending(0, peakIndex, target, mountainArr);
        if (left != -1) return left;

        return searchDescending(peakIndex + 1, mountainArr.length() - 1, target, mountainArr);
    }
}