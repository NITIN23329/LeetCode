//time O(n+h)  , space O(height)  excluding recursive stack
/*  approach 1 :
  --> find the path of both given nodes, store them in list
  --> as path is stored from node to root, first node present in both the path is the lca
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pp = new ArrayList<>();
        List<TreeNode> qq = new ArrayList<>();
        findPath(root,p,pp);
        findPath(root,q,qq);
        Set<TreeNode> set = new HashSet<>();
        for(TreeNode ele : qq)set.add(ele);
        for(TreeNode ele : pp)
            if(set.contains(ele))return ele;
        return null;
        
    }
    private boolean findPath(TreeNode root,TreeNode node , List<TreeNode> list){
        if(root==null)return false;
         if(root==node){
             list.add(root);
           return true;
         }
        boolean l = findPath(root.left,node,list);
        boolean r = findPath(root.right,node,list);
        if(l || r)
            list.add(root);
        return l||r;
    }
}

//time O(n) , space O(1) excluding recursive stack
/*  approach 2 :
      -->if my leftleft subtree find a node andy my right subtree find a node,then current root node is the lca
      -->if current root node is a given node and left or right subtree founds another node,then current rootn node is lca
*/
class Solution {
    private TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res=null;
        lca(root,p,q);
        return res;
    }
    private boolean lca(TreeNode root,TreeNode p,TreeNode q){
        if(root==null)return false;
        boolean l = lca(root.left,p,q);
        boolean r = lca(root.right,p,q);
        if(l && r)res=root;
        if((l || r ) && (root==p || root==q))res=root;
        return root==p || root==q || l|| r;
    }
}
