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
    private int totalNodes(ListNode head)
    {
        int count=1;
        ListNode currentNode=head;
        while(currentNode.next!=null)
        {
            currentNode=currentNode.next;
            count++;
        }
        return count;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        int totalElements=totalNodes(head);
        int removeElement=totalElements-n+1;

        ListNode firstNode=head;
        int count=1;
        while(count<removeElement-1)
        {
            firstNode=firstNode.next;
            count++;
        }

        if(totalElements==n)
        return head.next;

        else
        {
        firstNode.next=firstNode.next.next;
        return head;
        }
    }
}