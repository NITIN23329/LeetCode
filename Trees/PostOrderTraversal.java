
//time complexity O(n) , space Complexity O(n)
/*  approach 1 :
  peek the top , add right and left nodes in stack
  if peeked previously then it means we already processed its left and right subtree, hence pop the top node
  we keep track of previously peeked nodes using a set
*/
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        Set<TreeNode> peekedOnce = new HashSet<>();
        if(root==null)return list;
        dq.push(root);
        while(!dq.isEmpty()){
                TreeNode x = dq.peek();
                if(peekedOnce.contains(x))
                    list.add(dq.pop().val);
                else{
                    if(x.right!=null)dq.push(x.right);
                    if(x.left!=null)dq.push(x.left);
                    peekedOnce.add(x);
                }
            
        }
        return list;
    }
}
//time O(n) , space O(height)
// instead of using set , we can pop the top node and add it to the first of list
// after this we add left and right nodes. these nodes will be add to start of list later
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        LinkedList<Integer> list = new LinkedList<>();
        if(root==null)return list;
        dq.push(root);
        while(!dq.isEmpty()){
            TreeNode x = dq.pop();
            list.addFirst(x.val);
            if(x.left!=null)dq.push(x.left);
            if(x.right!=null)dq.push(x.right);
                
         }
        return list;
    }
}
