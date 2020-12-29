// time O(n) , space O(height)
/*   approach :
        --> form a current node , we can either goto left or right subtree
        --> we keep of a boolean value isLeft which tells whether to go to left or right which gets toggled 
        --> if isLeft is true , return 1 + length of largest path from node.left , 
        --> additionally we can start from current node and goto right subtree by 1 + length of largest path in node.right
        --> else if isLeft is false , return 1 + length of largest path from node.right
        --> additionally we can start from current node and goto left by 1 + length of largest path in node.left
*/
class Solution {
    int res = 0;
    public int longestZigZag(TreeNode root) {
        length(root,true);
        length(root,false);
        return res-1;
        
    }
    private int length(TreeNode root, boolean isLeft){
        if(root==null)return 0;
        if(isLeft){
            int x = 1+length(root.left,false);
            int y = 1+length(root.right,true);
            res = Math.max(res,Math.max(x,y));
            return x;
        }
        else{
            int x = 1+length(root.right,true);
            int y = 1+length(root.left,false);
            res = Math.max(res,Math.max(x,y));
            return x;
        }
    }
}
