//recursive
class Solution {
    public int maxDepth(Node root) {
        if(root==null)return 0;
        int max = 0;
        for(Node ele : root.children)
            max = Math.max(max, maxDepth(ele));
        return 1 + max;
    }
}
//iterative
class Solution {
    public int maxDepth(Node root) {
        Deque<Pair> dq = new ArrayDeque<>();
        if(root==null)return 0;
        dq.push(new Pair(root,1));
        int max = 0;
        while(!dq.isEmpty()){
            Pair x = dq.pop();
            max = Math.max(max,x.height);
            for(Node ele : x.node.children)
                dq.push(new Pair(ele,x.height+1));
            
        }
        return max;
    }
}
class Pair{
    Node node;
    int height;
    public Pair(Node n ,int h){
        node=n;
        height=h;
    }
}
