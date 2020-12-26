//time O(d) , space O(height) , recursive usinf dfs
/*  approach :
      -->one corner case is when d==1 , we need to create a new root and the existing root is the left subtree of new root
      --> goto the d-1 th add new row
*/
class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1){
            TreeNode x = new TreeNode(v);
            x.left = root;
            return x;
        }
        return dfs(root,v,d-1);
    }
    private TreeNode dfs(TreeNode root,int v,int d){
        if(root==null)return root;
        if(d==1){
            TreeNode l = root.left;
            root.left = new TreeNode(v);
            root.left.left = l;
            TreeNode r = root.right;
            root.right = new TreeNode(v);
            root.right.right = r;
            return root;
        }
        root.left = dfs(root.left,v,d-1);
        root.right = dfs(root.right,v,d-1);
        return root;
    }
}
// time O(N) , space O(N) , iterative using bfs
class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1){
            TreeNode x = new TreeNode(v);
            x.left = root;
            return x;
        }
        return bfs(root,v,d-1);
    }
    private TreeNode bfs(TreeNode root,int v,int d){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(d-->1){
            int s = q.size();
            for(int i=0;i<s;i++){
                 TreeNode x =q.poll();
                 if(x.left!=null)q.add(x.left);
                 if(x.right!=null)q.add(x.right);
            }
        }
        while(!q.isEmpty()){
            TreeNode x = q.poll();
            TreeNode l = x.left;
            x.left = new TreeNode(v);
            x.left.left = l;
            TreeNode r = x.right;
            x.right = new TreeNode(v);
            x.right.right = r;
    
        }
        return root;
    }
}
