// time O(n) , space O(height
/*  approach :
      --> do the pre order traversal or tree , we previously check if left node value is same as next value in voyage [] 
      --> if no , then do a swap for left and right child and add root to our result
      --> after swapping or not,if we get different value for root and voyage[i] , then there is no way to get our correct tree,thus return false
      --> then do a preorder recursively for left and right subtree
*/
class Solution {
    int i;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> list = new ArrayList<>();
        i=0;
        if(!find(list,root,voyage)){
            list =new ArrayList<>();
            list.add(-1);
        }
        return list;
    }
    private boolean find(List<Integer> list,TreeNode root,int[] voyage){
        if(i==voyage.length || root==null)return true;
        if(root.val!=voyage[i])return false;
        i++;
        if(i<voyage.length && root.left!=null && root.left.val!=voyage[i]){
            list.add(root.val);
            TreeNode l = root.left;
            root.left = root.right;
            root.right = l;   
        }
        boolean a = find(list,root.left,voyage);
        boolean b = find(list,root.right,voyage);
        return a&&b;
    }
}
