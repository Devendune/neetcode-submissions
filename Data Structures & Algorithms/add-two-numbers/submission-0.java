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
    private ListNode reverseList(ListNode list)
    {
        if(list==null || list.next==null)
        return list;

        ListNode prevNode=list;
        ListNode currentNode=prevNode.next;

        while(currentNode.next!=null)
        {
            ListNode nextNode=currentNode.next;
            currentNode.next=prevNode;
            prevNode=currentNode;
            currentNode=nextNode;
        }
        currentNode.next=prevNode;
        list.next=null;
        return currentNode;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        //ListNode l1=reverseList(l1);
        //ListNode l2=reverseList(l2);

        System.out.println("The list is reversed");

        ListNode curr=null,head=null,prev=null;
        int carry=0;
        while(l1!=null && l2!=null)
        {
            System.out.println("inside while loop");
            int totalSum=l1.val+l2.val+carry;
            carry=totalSum/10;
            curr=new ListNode(totalSum%10);

            if(head==null)
            {
            head=curr;
            prev=head;
            }

            else
            {
                prev.next=curr;
                prev=curr;
            }

            l1=l1.next;
            l2=l2.next;
        }

        while(l1!=null)
        {
            int totalSum=l1.val+carry;
            carry=totalSum/10;
            curr=new ListNode(totalSum%10);

            prev.next=curr;
            prev=curr;

            l1=l1.next;
        }

        while(l2!=null)
        {
            int totalSum=l2.val+carry;
            carry=totalSum/10;
            curr=new ListNode(totalSum%10);

            prev.next=curr;
            prev=curr;

            l2=l2.next;
        }
        if(carry!=0)
        {
            prev.next=new ListNode(carry);
        }

        return head;
    }
}