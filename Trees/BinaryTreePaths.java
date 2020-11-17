class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        form(root , list,"");
        return list;
    }
    private void form(TreeNode root , List<String> list,String curr){
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            list.add(curr+root.val);
            return;
        }
        curr+=root.val+"->";
        form(root.left,list,curr);
        form(root.right,list,curr);
    }
}

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        form(root , list, new StringBuilder());
        return list;
    }
    private void form(TreeNode root , List<String> list,StringBuilder curr){
        if(root==null)
            return;
        curr.append(root.val);
        if(root.left==null && root.right==null){
            list.add(curr.toString());
            return;
        }
        curr.append("->");
        int x = curr.length();
        form(root.left,list,curr);
        curr.setLength(x);    //it will take first x characters from the curr
        form(root.right,list,curr);
    }
}
