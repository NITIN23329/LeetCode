class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)return head;
       int len = 0;
        ListNode ii = head;
        while(true){
            ++len;
            if(ii.next==null){
                ii.next = head;
                break;
            }
            ii=ii.next;
        }
         k %=len;
        int z = len-k;
        while(z-->1)head = head.next;
        ListNode tt = head.next;
        head.next = null;
        return tt;
        
    }
}
