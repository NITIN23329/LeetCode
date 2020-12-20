//using queue  (iterative)
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)return list;
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> level = new ArrayList<>(s);
            for(int i=0;i<s;i++){
                Node x = q.poll();
                level.add(x.val);
                for(Node child : x.children)
                    q.add(child);
            }
            list.add(level);
        }
        return list;
    }
}
