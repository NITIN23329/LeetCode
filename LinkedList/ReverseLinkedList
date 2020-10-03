//problem link : https://leetcode.com/problems/reverse-linked-list/

//iterative method
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode past = null;
        ListNode curr = head;
        ListNode future = head.next;
        while(true){
            curr.next = past;
            past=  curr;
            curr=future;
            if(curr==null)break;
            future = curr.next;
        }
        return past;
    }
}

//recursive method

class Solution {
    public ListNode reverseList(ListNode head) {
       return reverse(head,null);
    }
    public ListNode reverse(ListNode curr,ListNode past){
        if(curr==null)return past;
        ListNode future = curr.next;
        curr.next = past;
        return reverse(future , curr);
    }
}
