class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }
        System.out.println(s1+" "+s2);
        ListNode sum = new ListNode(-1);
        ListNode iter = sum;
        while(!s1.isEmpty() && !s2.isEmpty()){
            int x = s1.pop() + s2.pop();
            iter.next = new ListNode(x%10);
            iter=iter.next;
            if(x>9){
                if(s1.isEmpty() && s2.isEmpty())iter.next = new ListNode(1);
                else if(!s1.isEmpty())s1.push(s1.pop()+1);
                else s2.push(s2.pop()+1);
            }
        }
        while(!s1.isEmpty()){
             int x = s1.pop() ;
            iter.next = new ListNode(x%10);
            iter=iter.next;
            if(x>9){
                if(s1.isEmpty())iter.next = new ListNode(1);
                else s1.push(s1.pop()+1);
            }
        }
        while(!s2.isEmpty()){
             int x = s2.pop() ;
            iter.next = new ListNode(x%10);
            iter=iter.next;
            if(x>9){
                if(s2.isEmpty())iter.next = new ListNode(1);
                else s2.push(s2.pop()+1);
            }
        }
        ListNode head = sum.next;
        sum.next = null;
        ListNode prev = null;
        while(head!=null){
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
        
    }
}
