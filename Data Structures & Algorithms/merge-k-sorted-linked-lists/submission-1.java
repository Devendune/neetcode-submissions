/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution 
{
    private ListNode mergeTwoSortedLists(ListNode l1,ListNode l2)
    {
        if(l1==null)
        return l2;

        if(l2==null)
        return l1;

        if(l1.val<=l2.val)
        {
            l1.next=mergeTwoSortedLists(l1.next,l2);
            return l1;
        }
        else
        {
            l2.next=mergeTwoSortedLists(l1,l2.next);
            return l2;
        }
    }
    private ListNode partitionAndMerge(int start,int end,ListNode[] lists)
    {
        if(start>end)
        return null;

        if(start==end)
        return lists[start];

        int mid=start+(end-start)/2;

        ListNode firstPartition=partitionAndMerge(start,mid,lists);
        ListNode secondPartition=partitionAndMerge(mid+1,end,lists);

        return mergeTwoSortedLists(firstPartition,secondPartition);

    }
    public ListNode mergeKLists(ListNode[] lists) 
    {
        int start=0;
        int end=lists.length-1;

        return partitionAndMerge(start,end,lists);

    }
}