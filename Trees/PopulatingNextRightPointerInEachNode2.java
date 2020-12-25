//iterative level order
class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root==null)return root;
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            for(int i=0;i<s;i++){
                Node x = q.poll();
                if(i!=s-1)x.next=q.peek();
                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
            }
        }
        return root;
    }
}
// recursive using hashmap
//hashmap stores the nearest left node
class Solution {
    Map<Integer,Node> map;
    public Node connect(Node root) {
        map = new HashMap<>();
        find(root,0);
        return root;
    }
    private void find(Node root,int level){
        if(root==null)return;
        if(map.containsKey(level))
            map.get(level).next=root;
        map.put(level,root);
        find(root.left,level+1);
        find(root.right,level+1);
        
    }
}
