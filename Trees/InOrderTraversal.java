//time O(n) , space O(height),  recursive
class Solution {
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        return list;
    }
    private void inOrder(TreeNode root,List<Integer> list){
        if(root==null)return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}
//time O(n) , space O(height) , iterative
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        while(root!=null || !dq.isEmpty()){
            while(root!=null){
                dq.push(root);
                root = root.left;
            }
            root = dq.pop();
            list.add(root.val);
            root=root.right;
        }
        return list;
    }
}
//timne O(N) , space O(1) morrish inorder
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        morrish(root,list);
        return list;
    }
    private void morrish(TreeNode root, List<Integer> list){
        while(root!=null){
            if(root.left==null){
                list.add(root.val);
                root=root.right;
            }else{
                TreeNode x = root.left;
                while(x.right!=null && x.right!=root)x=x.right;
                if(x.right==root){
                    x.right=null;
                    list.add(root.val);
                    root=root.right;
                }else{
                    x.right = root;
                    root = root.left;
                }
            }
        }
    }
}
