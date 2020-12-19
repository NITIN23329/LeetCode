//time O(N) , space O(N)
/*  approach :
    --> corner case is if we want to delete root node
    --> if we found a left node is to be deleted, delete that node by making node.left=null and recursivey look for 2 newly divided subtree by making isAdd=1.
    --> after finding 2 divided subtree, add them to list and then make isAdd=0 for no further addition to the list.
    -->similarly do for right node
*/
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> del = new HashSet<>();
        for(int ele : to_delete)del.add(ele);
        List<TreeNode> list = new ArrayList<>();
        if(del.contains(root.val)){
            delete(root,list,del,1);
        }else {
            list.add(root);
            delete(root,list,del,0);
        }
         
        return list;
    }
    private void delete(TreeNode root,List<TreeNode> list,Set<Integer> del,int isAdd){
        if(root==null)return ;
        if(root.left!=null && del.contains(root.left.val)){
            delete(root.left,list,del,1);
            root.left=null;
        }else delete(root.left,list,del,0);
        if(root.right!=null && del.contains(root.right.val)){
            delete(root.right,list,del,1);
            root.right=null;
        }else delete(root.right,list,del,0);
        if(isAdd==1){
            if(root.left!=null)
            list.add(root.left);
            if(root.right!=null)
            list.add(root.right);
        }
        
    }
}
