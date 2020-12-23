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
/*

The time complexity is actually O(N) which is a little more subtle. The outer while loop is executed O(N) iterations obviously, 
depending on the position of root in the InOrder serialization of the tree. In each such iteration, we have to find the left predecessor for cur, 
which is the costly part. Trivially you would think that gives us O(NlgN) per height of the tree. But if you think aggregately, you will see these:

For each node, we do find left predecessor on it only twice.
Throughout these two find left predecessor inner while loops, each edge of the tree get traversed at most twice.
You might have to draw a tree and doodle some trace to convince yourself this. Since a tree has N-1 edges, with N as the number of nodes, 
we know that the time complexity is O(N).
*/
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
