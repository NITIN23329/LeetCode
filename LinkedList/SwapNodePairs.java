lass Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)return head;
        //first swap is exception
        ListNode curr = head;
        ListNode future=head.next;
        curr.next = future.next;
        future.next = curr;
        head = future;
        while(true){
            future = curr.next;
            if(future ==null || future.next==null)break;
            curr.next=future.next;
            curr=curr.next;
            ListNode temp = curr.next;
            curr.next=future;
            future.next = temp;
            curr=future;
        }
        return head;
        
    }
}
