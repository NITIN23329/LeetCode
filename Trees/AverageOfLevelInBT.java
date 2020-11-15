//approach 1 : iterative using queue
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)return list;
        q.add(root);
        q.add(null);
        int c = 0;
        double sum = 0d;
        while(q.size()!=1){
            TreeNode x = q.poll();
            if(x==null){
                list.add(sum/c);
                sum=0d;
                c=0;
                q.add(null);
            }
            else{
                sum+=x.val;
                c++;
                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
            }
        }
        list.add(sum/c);
        return list;
    }
}
// recursive using HashMap
class Solution {
    private HashMap<Integer, Double[]> map ;
    public List<Double> averageOfLevels(TreeNode root) {
        map = new HashMap<>();
        helpr(root,0);
        List<Double> list = new ArrayList<>();
        for(int i=0;i<Integer.MAX_VALUE;i++){
            if(!map.containsKey(i))break;
            list.add(map.get(i)[0]/map.get(i)[1]);
        }
        return list;
    }
    private void helpr(TreeNode root , int height){
        if(root==null)return ;
        if(!map.containsKey(height))map.put(height,new Double[]{0d,0d});
        map.get(height)[0]+=root.val;
        map.get(height)[1]++;
        helpr(root.left,height+1);
        helpr(root.right,height+1);
    }
}
