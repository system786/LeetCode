class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode ans = new ListNode(0);
        ans.next = head;

        ListNode prev = ans, curr = ans, nex = ans;
        int total = 0;

        while (curr.next != null) {
            total++;
            curr = curr.next;
        }

        while (total >= k) {
            curr = prev.next;
            nex = curr.next;

            for (int i = 1; i < k; i++) {
                curr.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = curr.next;
            }

            total -= k;
            prev = curr;
        }

        return ans.next;
    }
}