class Solution {
    public int pairSum(ListNode head) {
        if(head == null) return -1;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverseList(slow);
        fast = head;
        int sum = 0;
        while(slow!=null){
            int ans = fast.val + slow.val;
            sum = (sum>ans)? sum:ans;
            slow = slow.next;
            fast = fast.next;
        }
        return sum;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = head;
        while(temp!=null){
            curr = temp.next;
            temp.next = prev;
            prev = temp;
            temp = curr;
        }
        return prev;
    }
}