// time O(n) , space O(n)
/*
  approach :
    --> store inorder and its corresponding index in a map
    --> traverse from right to left in post order array
    --> all nodes left to inorder index of a current node will be in left subtree
    --> all nodes right to inorder index of the current node will be in right subtree
*/
class Solution {
    private int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> in = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            in.put(inorder[i],i);
        index=inorder.length-1;
        return formTree(postorder, in,0,inorder.length-1);
    }
    private TreeNode formTree(int[] post,Map<Integer,Integer> in,int l,int r){
        if(index<0 || l>r)return null;
        TreeNode root = new TreeNode(post[index--]);
        int mid = in.get(root.val);
        root.right = formTree(post,in,mid+1,r);
        root.left = formTree(post,in,l,mid-1);
        return root;
    }
}
