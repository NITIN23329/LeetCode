class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> st = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if(root==null)return list;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode x = st.pop();
            if(x.right!=null)st.push(x.right);
             if(x.left!=null)st.push(x.left);
            list.add(x.val);
        }
        return list;
    }
}
