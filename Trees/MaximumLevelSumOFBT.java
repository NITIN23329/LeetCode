// do level order and find the level which has maximum sum
class Solution {
    public int maxLevelSum(TreeNode root) {
        ArrayList<Integer> levelSum = new ArrayList<>();
        int maxValue = Integer.MIN_VALUE;
        int currLevel=0;
        int maxLevel=0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            int curr = 0;
            for(int i=0;i<s;i++){
                TreeNode x = q.poll();
                curr+=x.val;
                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
            }
            currLevel++;
            if(curr>maxValue){
                maxValue = curr;
                maxLevel = currLevel;
            }
        }
        return maxLevel;
    }
}
