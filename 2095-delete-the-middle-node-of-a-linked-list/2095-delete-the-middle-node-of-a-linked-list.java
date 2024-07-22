class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode slow = prev;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;

        return head;
    }
}
