//time O(n), space O(HEIGHT) , iterative
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        while(root!=null || !dq.isEmpty()){
            while(root!=null){
                dq.push(root);
                list.add(root.val);
                root = root.left;
            }
            root =dq.pop();
            root=root.right;
        }
        return list;
    }
}
// time O(N), space O(1) using morrish preorder
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        while(root!=null){
            if(root.left==null){
                list.add(root.val);
                root=root.right;
            }
            else{
                TreeNode x = root.left;
                while(x.right!=null && x.right!=root)x=x.right;
                if(x.right==root){
                    x.right=null;
                    root=root.right;
                    
                }else {
                    x.right = root;
                    list.add(root.val);
                    root = root.left;
                }
            }
        }
        return list;
    }
}
