class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head,prev = null;

        while(temp != null){
            ListNode k = temp.next;
            
            if(temp.next != null && temp.val == temp.next.val){
                while(k != null && temp.val == k.val) {
                    k = k.next;
                }
                if( prev == null && k == null) {
                    head = null;
                    break;
                }
                else if(prev == null){
                    head = k;
                    temp = head;
                    prev = null;
                }
                else if( k == null){
                    prev.next = null;
                    break;
                } else {
                    prev.next = k;
                    temp = prev;
                }
                continue;
            }

            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}