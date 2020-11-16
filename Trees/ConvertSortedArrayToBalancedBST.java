class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return form(nums,0, nums.length-1);
    }
    private TreeNode form(int[] arr , int left , int right){
        if(left>right)return null;
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = form(arr , left , mid-1);
        root.right = form(arr , mid+1 , right);
        return root;
    }
}
