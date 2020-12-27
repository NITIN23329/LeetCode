//time O(n) , space O(2^height)
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean isEvenLevel = true;
        while(!q.isEmpty()){
            int s = q.size();
            int p=0;
            for(int i=0;i<s;i++){
                TreeNode x = q.poll();
                if(isEvenLevel){
                    if(x.val%2==0)return false;
                    if(i>0 && p>=x.val)return false;
                }else{
                    if(x.val%2==1)return false;
                    if(i>0 && p<=x.val)return false;
                }
                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
                p=x.val;
            }
            isEvenLevel = !isEvenLevel;
        }
        return true;
    }
}
