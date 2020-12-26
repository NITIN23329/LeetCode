//time O(n) , space O(n)
/*
  approach :
     --> store inorder and its corresponding index in a map
     --> traverse from left to right in pre order array
     --> all nodes left to inorder index of a current node will be in left subtree
     --> all nodes right to inorder index of the current node will be in right subtree
*/

class Solution {
    private int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> in = new HashMap<>();
        int n = preorder.length;
        for(int i=0;i<n;i++)in.put(inorder[i],i);
        index=0;
        return formTree(preorder,in,0,n-1);
    }
    private TreeNode formTree(int[] pre, Map<Integer,Integer> in,int l,int r){
        if(index==pre.length || l>r)return null;
        TreeNode root = new TreeNode(pre[index++]);
        int mid = in.get(root.val);
        root.left =formTree(pre,in,l,mid-1);
        root.right = formTree(pre,in,mid+1,r);
        return root;
    }
}
