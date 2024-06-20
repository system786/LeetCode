class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
            }

        ListNode middle=head,lefthead,righthead;
    
        middle = findmiddle(head);
        lefthead=head;
        righthead=middle.next;
        middle.next=null;
        lefthead=sortList(lefthead);
        righthead=sortList(righthead);
        return merge(lefthead,righthead);
    }
    public static ListNode merge(ListNode left,ListNode right) {
        ListNode temp=null,hed=null;

        while(left!= null && right != null){
            if(left.val > right.val){
                if(temp==null){
                    temp=right;
                    hed=temp;
                }
                else{
                    temp.next=right;
                    temp=temp.next;
                }
                right=right.next;
            }
            else{
                if(temp==null){
                    temp=left;
                    hed=temp;
                }
                else{
                    temp.next=left;
                    temp=temp.next;
                }
                left=left.next;
            }
        }
        if(left!=null){
            temp.next=left;
        }
        else{
            temp.next=right;
        }
        return hed;

    }
    public static ListNode findmiddle(ListNode head){
        ListNode fast=head,slow=head;
        if(head==null || head.next==null){
            return head;
        }
       
        while( fast.next!=null && fast.next.next!=null ){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
    }
}    
    
