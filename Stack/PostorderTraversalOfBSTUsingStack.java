/*approack 1 : using set to keep track of visited nodes. first we add root , then we add right child and then left child to stack.
* we pop from stack if leef node or left and right child is visited.
*/
class Solution {
   public List<Integer> postorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> st = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        if(root==null)return list;
        st.push(root);
       visited.add(null);
        while(!st.isEmpty()){
            TreeNode x = st.peek();
            //System.out.println(x.val);
            if((x.left==null && x.right==null) || (visited.contains(x.right) && visited.contains(x.left))){
                TreeNode z = st.pop();
                list.add(z.val);
                visited.add(z);
                continue;
            }
            if(x.right!=null)st.push(x.right);
            if(x.left!=null)st.push(x.left);

        }
        return list;
    }
}   
