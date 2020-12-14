//time O(N^2) , space O(N)
//approach : for every node , find the max diff in its subtree and return max of all nodes
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        int l = root.left==null? 0 : maxAncestorDiff(root.left);
        int r = root.right==null? 0 : maxAncestorDiff(root.right);
        return Math.max(find(root,root.val),Math.max(l,r));
    }
    private int find(TreeNode root,int x){
        if(root==null)
            return 0;
        int l = find(root.left,x);
        int r = find(root.right,x);
        return Math.max(Math.max(l,r), Math.abs(x-root.val));
    }
}
// bottom up (my solution)
// time O(N) , space O(height)
// find the max and min value from both right and left subtree and find the max diff of these value and root value
class Solution {
    private int max;      //will calculate the maximum diff btw node and its ancestors
    public int maxAncestorDiff(TreeNode root) {
         max=0;
         helpr(root);     // return an array having minimum and maximum value in the current tree
         return max;
    }
    private int[] helpr(TreeNode root){
        // l[] will have the min and max value found in left subtree of root
        int[] l = root.left==null ? new int[]{root.val,root.val} : helpr(root.left);
        // r[] will have min and max value found in right subtree of root
        int[] r = root.right==null ? new int[]{root.val,root.val}: helpr(root.right);
        // finding the max diff
        int a = Math.max(Math.abs(root.val-l[0]),Math.abs(root.val-r[0]));
        int b = Math.max(Math.abs(root.val-l[1]),Math.abs(root.val-r[1]));
        max = Math.max(Math.max(a,b),max);
        // will form the array having min value and max value including root node
        int[] curr = new int[2];
        curr[0] = Math.min(Math.min(l[0],r[0]),root.val);
        curr[1] = Math.max(Math.max(l[1],r[1]),root.val);
        return curr;
    }
}

//top down ( using https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/discuss/274610/JavaC%2B%2BPython-Top-Down)
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return topDown(root,root.val,root.val);
    }
    private int topDown(TreeNode root , int min,int max){
        if(root==null)return max-min;
        min = Math.min(min,root.val);
        max = Math.max(max,root.val);
        return Math.max(topDown(root.left,min,max),topDown(root.right,min,max));
    }
}
