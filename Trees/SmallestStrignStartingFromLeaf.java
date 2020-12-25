//find all paths , and choose chronological smallest one
class Solution {
    String min;
    public String smallestFromLeaf(TreeNode root) {
        min = "";
        findPath(root,new StringBuilder());
        return min;
    }
    private void findPath(TreeNode root,StringBuilder curr){
        if(root==null)return;
        curr.append((char)('a'+root.val));
        if(root.left==null && root.right==null){
            curr.reverse();
            String str = curr.toString();
            if(min.isEmpty() || min.compareTo(str)>0)min = str;
            curr.reverse(); 
        }
        findPath(root.left,curr);
        findPath(root.right,curr);
        curr.deleteCharAt(curr.length()-1);    
    }
}

