class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        int sum=0;
        if(root!=null && root.val%2==0){
            TreeNode l = root.left;
            if(l!=null){
                sum+=l.left==null ? 0 : l.left.val;
                sum+=l.right==null? 0:l.right.val;
            }
            TreeNode r = root.right;
            if(r!=null){
                sum+=r.left==null? 0 : r.left.val;
                sum+=r.right==null ? 0 : r.right.val;
            }
        }
        if(root==null)return sum;
        return sum + sumEvenGrandparent(root.left)+sumEvenGrandparent(root.right);
    }
}
