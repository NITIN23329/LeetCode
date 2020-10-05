
//Tortoise and rabit method (Floyd cycle detection). Constant space
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

//using dummy node , but we modity the given linkedlist
public class Solution {
    public boolean hasCycle(ListNode head) {
       ListNode dummy = new ListNode(-1);
        while(head!=null){
            if(head.next==dummy)return true;
            ListNode nextNode=head.next;
            head.next=dummy;
            head=nextNode;
        }
        return false;
    }
}

//another solution is to update the Node class. If we have extra field isVisisted which  is false initially for all Node
//On traversing , we mark a node as visited. if we found any vistide node upon traversing, we can say that this node is traversed already and hence a cycle is detected.
