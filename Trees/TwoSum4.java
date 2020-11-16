// approach 1 : using HashSet;
//time O(n)  , space O(n)
class Solution {
    private Set<Integer> set;
    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        return find(root,k);
    }
    private boolean find(TreeNode root , int k){
        if(root==null)return false;
        if(set.contains(k-root.val))return true;
        set.add(root.val);
        return find(root.left , k) || find(root.right , k);
    }
}
