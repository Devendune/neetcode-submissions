class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1. make sure k nodes exist; otherwise leave this part untouched
        ListNode check = head;
        for (int i = 0; i < k; i++) {
            if (check == null) return head;
            check = check.next;
        }

        // 2. reverse the first k nodes
        ListNode back = null, curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = back;
            back = curr;
            curr = next;
        }
        // back = new front of this group, curr = first node of the rest

        // 3. old head is now the group's tail; attach the processed rest
        head.next = reverseKGroup(curr, k);

        return back;
    }
}