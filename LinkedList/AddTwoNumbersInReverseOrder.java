class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode aa=l1,bb=l2;
        while(aa!=null){
            if(aa.next==null && bb.next!=null)aa.next = new ListNode(0);
            if(bb.next==null && aa.next!=null)bb.next = new ListNode(0);
            aa=aa.next;
            bb=bb.next;
        }
        aa=l1;
        bb=l2;
        while(aa!=null && bb!=null){
            int x = aa.val+bb.val;
            aa.val = x%10 ;
            if(x>9){
                if(aa.next==null)
                    aa.next = new ListNode(0);
                aa.next.val+=x/10;
            }
            aa=aa.next;
            bb=bb.next;
        }
        return l1;
    }
}
