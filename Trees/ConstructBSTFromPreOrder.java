//approach 1 : time O(n*n) , space O(n)
// as preorder tells the order in which values in tree is inserted , we simply contruct the BST from that
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=null;
        for(int i=0;i<preorder.length;i++)
            root = form(preorder[i],root);
        return root;
        
    }
    private TreeNode form(int x, TreeNode root){
        if(root==null){
            root = new TreeNode(x);
            return root;
        }
        if(root.val<x)
            root.right = form(x,root.right);
        else root.left = form(x,root.left);
        return root;
        
    }
}
//approach 2 : time O(nlogn) , if inOrder provided , time complexity had been O(n) , space complexity O(n)
/*  Binary Search technique
  1)find the inorder traversal , by sorting preorder array , store the index of each element in inorder in a map
  2)iterate over preorder array , form nodes , find its index in inorder using map
  3)recursively call of left and right part in inorder array
*/
class Solution {
    int index;
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        int[] inOrder = new int[n];
        for(int i=0;i<n;i++)
            inOrder[i]=preorder[i];
        Arrays.sort(inOrder);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(inOrder[i],i);
        index=0;
        return form(map,preorder,0,n-1);
    }
    private TreeNode form(Map<Integer,Integer> map,int[] pre,int l,int r){
        if(l>r || index>=pre.length)return null;
        TreeNode root = new TreeNode(pre[index++]);
        int mid = map.get(root.val);
        root.left = form(map,pre,l,mid-1);
        root.right = form(map,pre,mid+1,r);
        return root;
    }
}
//approach 3 : time O(n) , space O(height)
/*
  1) Inspired by approach 2
  2) instead of using index to check for bounds ,we can check value of node we are going to create as bounds
  3) if the value  we are going to create is not in the desired range of BST , we return null and can't create that node 
*/
class Solution {
    int index;
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        index=0;
        return form(preorder,0,Integer.MAX_VALUE);
    }
    private TreeNode form(int[] pre,int l,int r){
        if(index>=pre.length)return null;
        if(pre[index]<l || pre[index]>r)return null;
        TreeNode root = new TreeNode(pre[index++]);
        root.left = form(pre,l,root.val);
        root.right = form(pre,root.val,r);
        return root;
    }
}
