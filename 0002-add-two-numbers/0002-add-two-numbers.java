class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy  = new ListNode(0);
        ListNode l3 = dummy;
        int carry = 0;
        int currSum = 0;
        while(l1!=null||l2!=null){
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            currSum = val1+val2+carry;
            carry = currSum/10;
            int node = currSum%10;
             
            ListNode newNode = new ListNode(node);
            l3.next = newNode;

            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
            l3 = l3.next;
        }
        if(carry>0){
            ListNode newNode = new ListNode(carry);
            l3.next = newNode;
            l3 = l3.next;
        }

        return dummy.next;

        
    }
}