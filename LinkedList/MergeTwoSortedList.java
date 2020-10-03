//problem link : https://leetcode.com/problems/merge-two-sorted-lists/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merged;
        if(l1==null){merged=l2;return merged;}
        else if(l2==null){merged=l1;return merged;}
        else {
            if(l1.val>l2.val){
                merged = l2;
                l2=l2.next;
            }
            else{
                merged = l1;
                l1 = l1.next;
            }
        }
        ListNode head=merged;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                merged.next = l1;
                l1=l1.next;
            }
            else{
                merged.next = l2;
                l2=l2.next;
            }
            merged=merged.next;
        }
        if(l1!=null)merged.next=l1;
        else if(l2!=null)merged.next=l2;
        return head;
    }
}
