class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        int i = 0;
        while (first != null){
            if (i <= n){
                first = first.next;
                i++;
            } else {
                first = first.next;
                second = second.next;
            }
        }

        second.next = second.next.next;
        return dummy.next;
    }
}