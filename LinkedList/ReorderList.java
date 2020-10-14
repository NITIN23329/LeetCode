class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)return;
        ListNode slow=head,fast=head.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode tt = slow.next;
        slow.next = null;
        tt=reverse(tt);
        ListNode ii = head;
        while(tt!=null){
            ListNode jj=ii.next;
            ii.next=tt;
            tt=tt.next;
            ii.next.next = jj;
            ii=ii.next.next;
        }        
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode t = head.next;
            head.next=prev;
            prev=head;
            head=t;
        }
        return prev;
    }
}
