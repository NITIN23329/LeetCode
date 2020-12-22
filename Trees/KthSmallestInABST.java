//time O(k+height) , space O(height)
/*  approach :
    --> do inOrder traversal , whenever we visit a node , we update our counter
    --> when counter == k , we get our result
*/
class Solution {
    int c;
    TreeNode res;
    public int kthSmallest(TreeNode root, int k) {
        c=0;
        inOrder(root,k);
        return res.val;
        
    }
    private void inOrder(TreeNode root,int k){
        if(root==null || c>k)return;
        inOrder(root.left,k);
        c++;
        if(c==k)res = root;
        inOrder(root.right,k);
    }
   
}
//time O(height) , if we preprocess the findMin(), which calculate the no. of node < current node
/*
approach :
    --> find # of node < current node for every node and store it in a map or augmented tree
    -->then if # of min node > k-1 go to left subtree
    --> if # of min node < k-1 goto right subtree and reduce k by s+1 to remove all node in right tree including root node
*/
class Solution {
    Map<TreeNode,Integer> map;  //holds # of nodes less that the key node
    Map<TreeNode,Integer> c;    //holds # of nodes in a subtree startring for key nodes 
    public int kthSmallest(TreeNode root, int k) {
        map = new HashMap<>();
        c = new HashMap<>();
        findMin(root);
        return findK(root,k).val;
    }
    private void findMin(TreeNode root){
        if(root==null)return;
        findMin(root.left);
        findMin(root.right);
        map.put(root,count(root.left)); //finding number of nodes less that root
    }
    //simple recursive code to calculate # of nodes in a subtree
    private int count(TreeNode root){
        if(root==null)return 0;
        if(c.containsKey(root))return c.get(root); 
        int s = 1 +count(root.left)+count(root.right);
        c.put(root,s);
        return s;
    }
    private TreeNode findK(TreeNode root,int k){
        if(root==null)return null;
        int s = map.get(root);
        if(s==k-1)return root;
        if(s<k-1)return findK(root.right,k-1-s);
        return findK(root.left,k);
    }
    
}
