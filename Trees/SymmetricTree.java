/*approach 1 : recursive O(n) time  , time O(height)
*reverse right subtree
* check for same left and right subtree
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        TreeNode revB = reverse(root.right);
        return isSame(root.left , revB);
    }
    private boolean isSame(TreeNode a , TreeNode b){
        if(a==null)return b==null;
        if(b==null)return a==null;
        return a.val==b.val && isSame(a.left,b.left) && isSame(a.right,b.right);
    }
    private TreeNode reverse(TreeNode root){
        if(root==null)return root;
        TreeNode t= reverse(root.left);
        root.left = reverse(root.right);
        root.right = t;
        return root;
    }
}
/*approach 2 : recursive , timeO(N) , space O(height)
* check for same value in left subtee of 1 (a) with right subtree of other(b)
* check for same value in right subtree of 1(a) with left subtree of other(b)
*     eg)                 1                         1
                         / \                       / \
                        2   2                     2   2
                       /     \                   /   /
                      3       3                 3   3
                        TRUE                        FALSE
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root==null ?  true : isMirror(root.left , root.right);
    }
    private boolean isMirror(TreeNode a , TreeNode b){
        if(a==null)return b==null;
        if(b==null)return a==null;
        return a.val==b.val && isMirror(a.left,b.right) && isMirror(a.right,b.left);
   }
}
/*approach 3 : iteartive O(N) time since we see each node 3 times, space O(N)
*instead of using null to represent end of a level , use root node  .
* for 1st time of getting root , simply add its children.
* next time if we see root , we will check that our list is same from centre towards both end of q.
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        if(root==null)return true;
        q.addLast(root);
        q.addLast(root);
        boolean isFirstRoot = true; // we will set it false as soon as we see root for 1st time
        while(q.size()!=1){
            TreeNode x =q.removeFirst();
            if(x==root){
                if(isFirstRoot){
                    isFirstRoot = false;
                    q.addLast(root.left);
                    q.addLast(root.right);
                    continue;
                }
                //check out q has same values from centre to both ends of q
                int l = q.size()/2-1;
                int r = q.size()/2;
                if(q.size()%2==1)r++;
                while(l>=0){
                        if(q.get(l)==null){
                            if(q.get(r)!=null)return false;
                        }
                        else if(q.get(r)==null)return false;
                        else if(q.get(r).val!=q.get(l).val)return false;
                        l--;
                        r++;
                }
                q.addLast(root);
            }
            else if(x!=null){
                q.addLast(x.left);
                q.addLast(x.right);
            }
            
        }
        return true;
    }
}
