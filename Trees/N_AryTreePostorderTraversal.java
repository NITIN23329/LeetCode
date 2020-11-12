//iterative : time o(n)  , auixlary space o(n)
class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        Deque<Node> dq = new ArrayDeque<>();
        if(root==null)return list;
        dq.push(root);
        while(!dq.isEmpty()){
            Node x = dq.pop();
            list.addFirst(x.val);
            for(Node ele : x.children)
                dq.push(ele);
        }
        return list;
    }
}
//recursive : time o(n)  , auxilary space : O(height)
class Solution {
    private LinkedList<Integer> list ; 
    public List<Integer> postorder(Node root) {
        list = new LinkedList<>();
        helpr(root);
        return list;
    }
    private void helpr(Node root){
        if(root==null)return ;
        list.addFirst(root.val);
        for(int i=root.children.size()-1 ;i>=0;i--)
            helpr(root.children.get(i));
    }
}
