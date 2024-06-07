class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        
        int size = 1;
        ListNode node = head;
        while (node.next != null) {
            size++;
            node = node.next;
        }
        node.next = head;
        
        int stepsToNewHead = size - (k % size);
        for (int i = 0; i < stepsToNewHead; i++) {
            node = node.next;
        }
        
        ListNode newHead = node.next;
        node.next = null;
        
        return newHead;
    }
}
