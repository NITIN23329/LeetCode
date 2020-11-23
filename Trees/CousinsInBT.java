class Solution {
    public boolean isCousins(TreeNode root, int a, int b) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean is1 = false;
        while(!q.isEmpty()){
            int s = q.size();
            for(int i=0;i<s;i++){
                TreeNode x =q.poll();
                if(x.val==a || x.val==b){
                    if(!is1)is1 = true;
                    else return true;
                }
                if(x.left!=null && x.right!=null){
                    if((x.left.val==a || x.left.val==b) &&
                        (x.right.val==a || x.right.val==b))return false;
                }
                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
            }
            if(is1)return false;
        }
        return false;
    }
    
}
