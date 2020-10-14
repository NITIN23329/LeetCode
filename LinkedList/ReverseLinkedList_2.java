class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead=new ListNode(-1);  //dummy node is made to take care of m=1 case
        newHead.next = head;
        head=newHead;
        int t = m;
        while(t-->1)head=head.next;
        ListNode prev = null;
        ListNode iter = head.next;
        int z = n-m;
        while(z-->-1){
            ListNode temp=iter.next;
            iter.next=prev;
            prev=iter;
            iter=temp;
        }
        head.next.next = iter;
        head.next= prev;
        return newHead.next;
        
    }
}
