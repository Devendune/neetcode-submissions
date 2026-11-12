class Solution 
{
    public ListNode reverseBetween(ListNode head, int left, int right) 
    {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        // 1. move prev to the node just before the segment
        for (int i = 1; i < left; i++)
            prev = prev.next;

        // 2. this node is the segment's first node now, and its tail after reversing
        ListNode segmentTail = prev.next;

        // 3. reverse exactly (right - left + 1) nodes
        ListNode curr = segmentTail;
        ListNode back = null;
        for (int i = 0; i < right - left + 1; i++)
        {
            ListNode next = curr.next;
            curr.next = back;
            back = curr;
            curr = next;
        }

        // 4. link the two ends
        prev.next = back;          // node before the segment -> new front of reversed part
        segmentTail.next = curr;   // old first node (now the tail) -> node after the segment

        return dummy.next;
    }
}