//using hashset . space O(n) , time O(n)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        Set<Integer> dup = new HashSet<>();
        ListNode ll=head;
        while(ll.next!=null){
            if(ll.val==ll.next.val)dup.add(ll.val);
            ll=ll.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next =head;
        ListNode ret = dummy;
        while(head!=null){
            if(!dup.contains(head.val)){
                dummy.next = head;
                dummy =dummy.next;
            }
            head = head.next;
        }
        dummy.next = null;
        return ret.next;
    }
}
// inplace O(1) space , O(n) time
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ret = dummy;
        while(head!=null && head.next!=null){
            if(head.val==head.next.val){
                while( head.next!=null && head.val==head.next.val)head=head.next;
                head=head.next;
                if(head==null)break;
            }
            if(head.next!=null && head.val==head.next.val)continue;
            dummy.next = head;
            dummy = dummy.next;
            head = head.next;
        }
        if(head!=null && dummy.val!=head.val){
            dummy.next = head;
            dummy = dummy.next;
        }
        dummy.next = null;
        return ret.next;
    }
}
