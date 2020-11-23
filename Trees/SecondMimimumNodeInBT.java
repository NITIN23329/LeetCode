/* approach : recursive 
* as each node is the minimum value which can be seen in its subtree ,
* suppose if the root.val !=root.right.val , then it is obvious that right subtree got minumum val as root.right.val
*same is true for left subtree 
* but if root.val==root.left.val , then find recursively the above for root.left node
* same is true for right subtree
* find min of all what we got from left and right subtree
*
*/

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        int l =-1;
        int r = -1;
        if(root.left!=null){
            if(root.left.val!=root.val)
                l = root.left.val;
            else l=findSecondMinimumValue(root.left);
        }
        if(root.right!=null){
            if(root.right.val!=root.val)
                r =  root.right.val;
            else r = findSecondMinimumValue(root.right);
        }
        if(l==-1)return r;
        if(r==-1)return l;
        return Math.min(l,r);
    }
    
}
