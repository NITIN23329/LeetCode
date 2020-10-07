class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)return true;
        ListNode slow=head,fast=head.next;
        //finfing middle node
        while(fast!=null && fast.next!=null ){
            fast=fast.next.next;
            slow = slow.next;
        }
        //reversing the secound half of list
        ListNode sec = slow.next;
        slow.next=null;
        sec=reverse(sec,null);
        
        //checking fist half and second half lists are same or not
        while(sec!=null){
            if(sec.val!=head.val)return false;
            sec=sec.next;
            head=head.next;
        }
        return true;
        
    }
    private ListNode reverse(ListNode curr , ListNode prev){
        ListNode future = curr.next;
        curr.next =  prev;
        if(future==null)return curr;
        return reverse(future , curr);
    }
}
