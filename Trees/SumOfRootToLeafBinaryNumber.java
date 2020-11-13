/* slower using String
 * but this solution is more intuitive that below one
 *approach : store the binary number(traversing from top to down in a tree) in a string 
 *and when we reach a leaf root , convert binary string to decimal and add to sum
 */
class Solution {
    private int sum;
    public int sumRootToLeaf(TreeNode root) {
        sum=0;
        helpr(root,"");
        return sum;
    }
    private void helpr(TreeNode root , String str){
        if(root==null)return;
        if(root.left==null && root.right==null){
            str+=root.val;
            sum+= Integer.parseInt(str,2);
            return;
        }
        helpr(root.left , str+root.val);
        helpr(root.right,str+root.val);
    }
}
//faster using int
// approach is same as above but instead of string , int is used
class Solution {
    public int sumRootToLeaf(TreeNode root) {
      return helpr(root,0);
    }
    private int helpr(TreeNode root ,int curr){
        if(root==null)return 0 ;
        if(root.left==null && root.right==null)
           return curr = 2*curr + root.val;
           
        return helpr(root.left , curr*2+root.val)+
                        helpr(root.right,curr*2+root.val);
    }
}
