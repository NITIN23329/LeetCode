

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode iterA = headA,iterB=headB;
        if(headA==null || headB==null)return null;
        boolean first=true;
        while(true){
            if(iterA==iterB)return iterA;
            iterA=iterA.next;
            if(iterA==null && first){
                iterA=headB;
                first=false;
            }
            else if(iterA==null && !first) break;
            iterB=iterB.next==null ? headA : iterB.next;
        }
        return null;
    }
}

//another approach

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1=0,l2=0;
        ListNode iter=headA;
        while(iter!=null){
            iter=iter.next;
            l1++;
        }
        iter=headB;
        while(iter!=null){
            iter=iter.next;
            l2++;
        }
        if(l1<=l2){
            int z = l2-l1;
            while(z-->0){
                headB=headB.next;
            }
        }
        else{
            int z = l1-l2;
            while(z-->0)headA=headA.next;
        }
        while(headA!=null && headB!=null){
            if(headA==headB)return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
        
    }
}
