class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode newList = new ListNode(0);
        newList.next=  head;
        head = newList;
        ListNode iter = head.next;
        while(iter!=null){
            if(iter.val!=val){
                head.next = iter;
                head=head.next;
            }
            iter=iter.next;
        }
        head.next=  null;
        return newList.next;
    }
}
