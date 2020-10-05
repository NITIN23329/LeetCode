
//Tortoise and rabit method. Constant space
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null)return false;
        ListNode slow=head;
        ListNode fast = head.next;
        while(true){
            if(slow==fast)break;
            if(fast==null || fast.next==null)return false;
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }
}

// using HashSet . Linear space
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null )return false;
        Set<ListNode> set = new HashSet<>();
        while(head!=null){
            if(set.contains(head))return true;
            set.add(head);
            head=head.next;
        }
        return false;
    }
}
