class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)return head;
       ListNode odd=head;
       ListNode even=head.next;
       ListNode temp=head.next;
        while(true){
            odd.next=even.next;
            if(odd.next==null)break;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
            if(even==null)break;
    
        }
        odd.next=temp;
        return head;
    }
}
