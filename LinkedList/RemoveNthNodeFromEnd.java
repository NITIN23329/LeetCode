// using hashMap , space O(n) ,time O(n) , one-pass only
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();
        int c = 0;
        ListNode t=head;
        while(head!=null){
            map.put(++c , head);
            head = head.next;
        }
        if(n==map.size()){
            return t.next;
        }
        ListNode remove = map.get(map.size()-n);
        remove.next =remove.next.next;
        return t;
    }
}
// using 2 pointers approach  ,  time O(n)  , space O(1) , one pass only
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while(n-->0)fast=fast.next;
        ListNode slow= head;
        if(fast==null)return head.next;
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
