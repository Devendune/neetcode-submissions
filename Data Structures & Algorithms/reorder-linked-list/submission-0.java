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
    private ListNode middleElement(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head)
    {
        ListNode firstNode=head;
        ListNode secondNode=head.next;
        ListNode thirdNode=secondNode.next;
        head.next=null;

        while(secondNode.next!=null)
        {
            secondNode.next=firstNode;
            firstNode=secondNode;
            secondNode=thirdNode;

            thirdNode=thirdNode.next;
        }
        secondNode.next=firstNode;
        return secondNode;
    }
    public void reorderList(ListNode head) 
    {
        if(head==null || head.next==null || head.next.next==null)
        return;


        ListNode middleNode=middleElement(head);
        ListNode reversed=reverse(middleNode);
        ListNode answer=head;
        ListNode currentNext=head.next;
        ListNode reversedNext=reversed.next;

        while(head!= null && reversed.next!=null)
        {
            head.next=reversed;
            head=currentNext;
            reversed.next=head;
            currentNext=currentNext.next;
            reversed=reversedNext;
            reversedNext=reversedNext.next;
        }
        head=answer;
    }
}