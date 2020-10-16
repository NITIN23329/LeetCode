class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1 || head==null)return head;
        ListNode ff_prev = null,ff=head,ss_prev=head,ss=null;
        while(true){
           int z = ss==null ? k-1 :k;  // if ss==null then we are doing reversal for first time , so z=k-1;
            while(ss_prev!=null && z-->0)
                ss_prev = ss_prev.next;
            if(ss_prev==null)break;
            ss=ss_prev.next;
            ss_prev.next = null;
            ListNode[] arr = reverse(ff);
            if(ff_prev==null)head=arr[0];   //first time reversal take place
            else ff_prev.next  = arr[0];
            arr[1].next = ss;
            ss_prev = arr[1];
            ff_prev = ss_prev;
            ff=ss;
        }
        return head;
    }
    private ListNode[] reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode fut = curr.next;
            curr.next = prev;
            prev=curr;
            curr = fut;
        }
        return new ListNode[]{prev , head};
    }
}
