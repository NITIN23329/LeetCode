//time O(N) , space O(height)
/* approach:
    ->for a pseudo palindromic path , every digit from 1 to 9 must have even # of occurences but 1 (may or may not). eg 22122 or 2222
    ->store the # of occurence of every digit along a path from root to leaf , as soon as we find leaf , check the current path is preudo palindromic or not
    -> remove the occurence of digits in current path and goto another path
*/
class Solution {
    private int[] arr;
    public int pseudoPalindromicPaths (TreeNode root) {
        arr = new int[10];
        return  find(root);
    }
    private int find(TreeNode root){
        arr[root.val]++;
        if(root.left==null && root.right==null){
            int odd = 0;
            for(int ele : arr)
                if(ele%2==1)odd++;
            arr[root.val]--;
           return odd<=1 ? 1 : 0;
        }
        int ans = 0;
        if(root.left!=null)ans+=find(root.left);
        if(root.right!=null)ans+=find(root.right);
        arr[root.val]--;
        return ans;
    }
}
