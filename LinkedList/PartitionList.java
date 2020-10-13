class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null)return head;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        head=dummy;
        ListNode tail;
        ListNode iter=head;
        while(iter.next!=null)iter=iter.next;
        tail = iter;
        ListNode temp=null;
        while(head.next!=temp){
            if(head.next.val>=x){
                tail.next = head.next;
                head.next =  head.next.next;
                tail = tail.next;
                tail.next=null;
                if(temp==null)temp=tail;
            }
            else head=head.next;
        }
        return dummy.next;
    }
}

// another efficient solution 
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null)return head;
        ListNode smaller = new ListNode(-1);
        ListNode greater = new ListNode(-1);
        ListNode s=smaller,g=greater;
        while(head!=null){
            if(head.val<x)
                smaller = smaller.next = head;
            else greater=greater.next=head;
            head=head.next;
        }
        smaller.next = g.next;
        greater.next=null;
        return s.next;
    }
}
