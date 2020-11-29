/*
approach : time O(N) , space O(height)
* find the path of target node in original tree ,
      then follow the same path in cloned tree to find cloned target.

* To find the path of target in original tree , use a stack,
  first add 'L' to stack ,denoting we are going to left subtree 
  if we found target node by going to left subtree , we stop and return true
  else  we remove the letter 'L' for stack.
  Likewise , add 'R' to stack and traverse right subtree , 
  if we found target node in right subtree ,we return true and stop
  else remove 'R' and return false, in that case node is not present in original tree
*/
class Solution {
     private LinkedList<Character> path;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        path = new LinkedList<>();
       if(!findPath(original,target))return null;
        TreeNode x = cloned;
       for(int i=0;i<path.size();i++)
           if(path.get(i)=='L')
               x=x.left;
           else x=x.right;
       return x;
        
    }
    private boolean findPath(TreeNode root,TreeNode target){
        if(root==null)
            return false;
        if(root==target)
            return true;
        path.addLast('L');
        if(findPath(root.left,target))
            return true;
        path.removeLast();
        path.addLast('R');
        if(findPath(root.right,target))
            return true;
        path.removeLast();
        return false;
    }
}
