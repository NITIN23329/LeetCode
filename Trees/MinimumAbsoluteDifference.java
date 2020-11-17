//approach1 : using inOrder, ,time O(N) space O(N)
class Solution {
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root,list);
        int min = 9999999;
        for(int i=0;i<list.size()-1;i++)
            min = Math.min(min , list.get(i+1)-list.get(i));
        return min;
    }
    private void inOrder(TreeNode root, ArrayList<Integer> list){
        if(root==null)return;
        inOrder(root.left , list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}
//time : O(nlogn) average case , space : O(1) if we use morrish inorder else O(height)
class Solution {
    public int getMinimumDifference(TreeNode root) {
        if(root==null)return Integer.MAX_VALUE;
        int l  = Math.abs(precedor(root.left)-root.val);
        int r = Math.abs(sucessor(root.right)-root.val);
        int lt = getMinimumDifference(root.left);
        int rt = getMinimumDifference(root.right);
        return Math.min(Math.min(l,r), Math.min(lt,rt));
    }
    private int precedor(TreeNode root){
        if(root==null)return Integer.MAX_VALUE;
        while(root.right!=null)root=root.right;
        return root.val;
    }
    private int sucessor(TreeNode root){
        if(root==null)return Integer.MAX_VALUE;
        while(root.left!=null)root=root.left;
        return root.val;
    }
}
