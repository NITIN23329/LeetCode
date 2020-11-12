//time O(n) ,  space o(n) 
// use in order to get sorted tree and update links to form a linkedList
class Solution {
    private ArrayList<TreeNode>  list;
    public TreeNode increasingBST(TreeNode root) {
        list = new ArrayList<>();
        inOrder(root);
        for(int i=0;i<list.size()-1;i++){
            list.get(i).right = list.get(i+1);
            list.get(i).left = null;
        }
            
        return list.get(0);
    }
    private void inOrder(TreeNode x){
        if(x==null)return;
        inOrder(x.left);
        list.add(x);
        inOrder(x.right);
    }
}
