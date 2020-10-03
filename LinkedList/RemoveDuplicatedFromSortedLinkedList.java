//problem link : https://leetcode.com/problems/remove-duplicates-from-sorted-list/
//iterative solution
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return head;
        ListNode up = head;
        ListNode curr = up;
        head=head.next;
        while(head!=null){
            if(curr.val!=head.val){
                curr.next=head;
                curr=head;
            }
            head=head.next;
        }
        curr.next=null;
        return up;
    }
}

//recursive solution
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return head;
        delete(head,head.next);
        return head;
    }
    public void delete(ListNode last , ListNode curr){
        if(curr==null)return ;
        delete(curr,curr.next);
       last.next = last.val==curr.val?curr.next:curr;
       
    }
}
