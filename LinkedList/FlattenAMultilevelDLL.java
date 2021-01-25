// time complexity O(n) , space complexity O(n) ; n = # of total nodes
/*
  approach :
      --> maintain a global pointer node of our resulted flattened doubly ll which points towards last node in it.
      --> initially our last node points toward a dummy node -1.
      --> first connect current node to our resulted flattened doubly ll.
      --> then connect all current nodes's child nodes
      --> and then connect current nodes's next node
      -->after created our resulted flattened doubly ll, we need to remove the dummy node which is at head of our resulted flattened doubly ll.
*/
class Solution {
    private Node last;
    public Node flatten(Node head) {
        if(head==null)return null;
        last = new Node(-1);
        Node headFlat = last;
        dfs(head);
        headFlat = headFlat.next;
        headFlat.prev = null;
        return headFlat;
    }
    private void dfs(Node iterOrig){
        if(iterOrig==null)return ;
        Node x = new Node(iterOrig.val);
        last.next = x;
        x.prev = last;
        last = last.next;
        dfs(iterOrig.child);
        dfs(iterOrig.next);
    }
}
// time complexity O(n) , space complexity O(1) inplace ; n = # of total nodes
/*  approach :
      --> same as of previous solution
      --> instead of creating new nodes in our resulted flattened doubly ll,
      --> connect last to current node.
      --> make child and next of current node to null but store there poniter in temporary variable;
      --> call for child and next of current node using temporary variable created above.
*/
class Solution {
    private Node last;
    public Node flatten(Node head) {
        if(head==null)return null;
        last = new Node(-1);
        Node headFlat = last;
        dfs(head);
        headFlat = headFlat.next;
        headFlat.prev = null;
        return headFlat;
    }
    private void dfs(Node iterOrig){
        if(iterOrig==null)return ;
        Node child = iterOrig.child;
        iterOrig.child = null;
        Node next = iterOrig.next;
        iterOrig.next = null;
        last.next = iterOrig;
        iterOrig.prev = last;
        last = last.next;
        dfs(child);
        dfs(next);
    }
}
