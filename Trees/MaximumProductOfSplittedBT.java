// time O(n) , height O(height)
/*  approach
    --> remove every edge, find the product of sum of 2 disconnected tree
    --> initially find the total sum of the given tree = total
    --> consider every subtree , find its corresponding product by multipling the sum of subtree and total-sum of subtree
*/
class Solution {
    long res;
    int mod;
    public int maxProduct(TreeNode root) {
        long total = traverse(root);
        mod = (int)1e9+7;
        res = 0L;
        findMax(root,total);
        return (int)(res%mod);
    }
    private long traverse(TreeNode root){
        if(root==null)return 0L;
        return 0L+root.val+traverse(root.left)+traverse(root.right);
    }
    private long findMax(TreeNode root,long total){
        if(root==null)return 0L;
        long l = findMax(root.left,total);
        long r =  findMax(root.right,total);
        long curr = l+r+root.val;
        res = Math.max(res,curr*(total-curr));
        return curr;
       }
}
