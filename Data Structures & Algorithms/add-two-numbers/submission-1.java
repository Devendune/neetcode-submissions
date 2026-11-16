class Solution 
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode curr=null,head=null,prev=null;
        int carry=0;
        while(l1!=null || l2!=null)
        {
            int totalSum=carry;
            if(l1!=null)
            {
            totalSum+=l1.val;
            l1=l1.next;
            }

            if(l2!=null)
            {
            totalSum+=l2.val;
            l2=l2.next;
            }

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
        }

        if(carry!=0)
        prev.next=new ListNode(carry);
    
        return head;
    }
}