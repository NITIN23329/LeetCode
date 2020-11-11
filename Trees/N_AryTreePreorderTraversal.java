//recursive : O(n) : auxiliary space O(height) 
class Solution {
    private List<Integer> list;
    public List<Integer> preorder(Node root) {
        list = new ArrayList<>();
        if(root==null)return list;
        helpr(root);
        return list;
    }
    private void helpr(Node root){
        if(root==null)return;
        list.add(root.val);
        for(Node t : root.children)
            helpr(t);
    }
}

// time O(n) : auxiliary space O(n)
class Solution {
    public List<Integer> preorder(Node root) {
         List<Integer> list = new ArrayList<>();
         Deque<Node> dq = new ArrayDeque<>();
        if(root==null)return list;
        dq.push(root);
        while(!dq.isEmpty()){
            Node x = dq.pop();
            list.add(x.val);
            for(int i = x.children.size()-1;i>=0;i--)
                dq.push(x.children.get(i));
        }
        return list;
    }
}
