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
class Solution {
    public ListNode reverseList(ListNode head) 
    {
        if(head==null || head.next==null)
        return head;

        ListNode currNode=head.next;
        ListNode nextNode=currNode.next;
        head.next=null;

        while(currNode.next!=null)
        {
            currNode.next=head;
            head=currNode;
            currNode=nextNode;

            nextNode=nextNode.next;
        }
        currNode.next=head;
    return currNode;
    }
}