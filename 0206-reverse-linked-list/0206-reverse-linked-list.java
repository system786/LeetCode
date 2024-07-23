class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newnode=null;
        while(head!=null){
            ListNode temp=head;
            head=head.next;
            temp.next=newnode;
            newnode=temp;
        }
        return newnode;
    }
}