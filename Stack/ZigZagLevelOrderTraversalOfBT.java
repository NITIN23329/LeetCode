//time O(n) and space O(n)
// using 2 stack
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> s1 = new ArrayDeque<>();
        Deque<TreeNode> s2 = new ArrayDeque<>();
        
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)return list;
        s1.push(root);
        while(!(s1.isEmpty() && s2.isEmpty())){
             List<Integer> t = new ArrayList<>();
            if(s2.isEmpty()){
               while(!s1.isEmpty()){
                    TreeNode n = s1.pop();
                    t.add(n.val);
                    if(n.left!=null)s2.push(n.left);
                    if(n.right!=null)s2.push(n.right);
               }
            }
            else{
                 while(!s2.isEmpty()){
                    TreeNode n = s2.pop();
                     t.add(n.val);
                    if(n.right!=null)s1.push(n.right);
                    if(n.left!=null)s1.push(n.left);
                }
            }
            list.add(t);
        }
        return list;
    }
}
