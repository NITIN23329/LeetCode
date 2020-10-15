//using hash map O(n) time  ,  O(n) space
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node , Node> ori_dup= new HashMap<>();
        Node t = head;
        while(head!=null){
            ori_dup.put(head , new Node(head.val));
            head = head.next;
        }
        for(Node ori : ori_dup.keySet()){
            Node dup  = ori_dup.get(ori);
            dup.next = ori_dup.get(ori.next);
            dup.random = ori_dup.get(ori.random);
        }
        return ori_dup.get(t);
    }
}

// using origional list , time O(n)  , space o(1)

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        Node ll = head;
        while(ll!=null){
            Node nn = ll.next;
            ll.next = new Node(ll.val);
            ll.next.next = nn;
            ll=ll.next.next;
        }
        ll=head;
        while(ll!=null){
            Node rp = ll.random;
            ll.next.random = rp==null ? null : rp.next;
            ll=ll.next.next;
        }
        Node copy = head.next;
        Node rr=copy;
        while(true){
            head.next = copy.next;
            head=head.next;
            if(head==null)
                break;
            copy.next = head.next;
            copy=copy.next;
          
        }
        return rr;
    }
}
