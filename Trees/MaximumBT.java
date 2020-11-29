//time comlexity = O(N*N) when array is sorted
/*
approach 1 : 
for every window from l to r , find maximum , make it root and call recursively for left and right window
*/
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return form(nums,0,nums.length-1);
    }
    private TreeNode form(int[] arr, int l,int r){
        if(l>r)
            return null;
        int max =Integer.MIN_VALUE;
        int mid = -1;
        for(int i=l;i<=r;i++){
            if(max<arr[i]){
                mid = i;
                max = arr[i];
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = form(arr,l,mid-1);
        root.right = form(arr,mid+1,r);
        return root;
    }
}
// time complexity O(nh) , h=height of array
/*
approach2 : 
in moving forward in an array, if we found current to be maximum, make it root, 
and the currently created tree will be left subtree of current maximum as we found them earlier.
else goto right subtree as it is not found earlier and do above until  you found null
*/
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] arr) {
        TreeNode root=null;
        for(int i=0;i<arr.length;i++)
            root = insert(root,arr[i]);
        return root;
    }
    private TreeNode insert(TreeNode root , int x){
        if(root==null){
            root = new TreeNode(x);
            return root;
        }
        if(root.val<x){
            TreeNode n = new TreeNode(x);
            n.left = root;
            return n;
        }
        root.right = insert(root.right ,x);
        return root;
    }
}
//time : O(n) using stack
/*
approach is same as above, code : inspired by https://leetcode.com/problems/maximum-binary-tree/discuss/106156/Java-worst-case-O(N)-solution
maintain a stack , pop while current element in greater and make it left subtree to current node as found before , 
if stack becomes empty , current is the maximum , make it new root and previous root will be left subtree
else add the current node to left subtree of the top stack node
*/

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] arr) {
        TreeNode root=null;
        Deque<TreeNode> dq = new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            root = insert(root,arr[i],dq);
        }
            
        return root;
    }
    private TreeNode insert(TreeNode root , int x,Deque<TreeNode> dq){
        TreeNode n = new TreeNode(x);
        while(!dq.isEmpty() && dq.peek().val<x)
            n.left = dq.pop();
        if(!dq.isEmpty())
            dq.peek().right = n;
        else{
            n.left = root;
            root = n;
        }
         dq.push(n);
        return root;
    }
}
