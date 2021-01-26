// time complexity O(N) , space complexity O(height)
/*  approach :
        --> as we are given the starting red color node(x), the only place to start coloring blue that ensures blue to win is to color any adjacent node of x to blue.
        --> if we color left child of x to blue then we can stop the red color player to color any node of subtree starting from the left child of x.
        --> similar goes for  right child for x.
        --> if we initially color parent node of x to blue , then we can stop the red color player to color upper nodes of x and their remaining children.
        --> in either case blue player will be coloring only 1 part(left subtree/right subtree/ parent tree) and rest 2 parts are colored by red.
        --> find # nodes in any 1 part > # of nodes in remaining 2 parts , if yes then blue can win else cann't.
*/
class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode redColor = findRedColor(root,x);
        int leftSubtree = count(redColor.left,null);
        int rightSubtree = count(redColor.right,null);
        int parentTree = count(root,redColor);
        if(leftSubtree> rightSubtree + parentTree)return true;
        if(rightSubtree> leftSubtree + parentTree)return true;
        if(parentTree> rightSubtree + leftSubtree)return true;
        return false;
    }
   
    private TreeNode findRedColor(TreeNode root,int x){
        if(root==null)return null;
        if(root.val==x)return root;
        TreeNode l = findRedColor(root.left,x);
        if(l!=null)return l;
        return findRedColor(root.right,x);
    }
    private int count(TreeNode root, TreeNode redColor){
        if(root==null || root==redColor)return 0;
        return 1 + count(root.left,redColor) + count(root.right,redColor);
    }
}
