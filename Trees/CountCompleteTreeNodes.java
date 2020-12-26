//time O(h*h) = O(logn*logn)
//solution link : https://www.youtube.com/watch?v=CvrPf1-flAA
class Solution {
    public int countNodes(TreeNode root) {
        int ld = depth(root,true);
        int rd = depth(root,false);
        if(ld==rd)
            return (int)Math.pow(2,ld)-1;
        return 1 + countNodes(root.left)+countNodes(root.right);
    }
    private int depth(TreeNode root,boolean isLeft){
        int d=0;
        while(root!=null){
            d++;
            root = isLeft? root.left : root.right;
        }
        return d;
    }
}
