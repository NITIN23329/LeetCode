//approach 1 : iterative using queue LevelOrder
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> list = new LinkedList<>();
        if(root==null)return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> temp=  new LinkedList<>();
        while(q.size()!=1){
            TreeNode x = q.poll();
            if(x==null){
                list.addFirst(temp);
                temp = new LinkedList<>();
                q.add(x);
            }
            else{
                temp.add(x.val);
                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
            }
        }
          list.addFirst(temp);
        return list;
    }
}
//approach 2 : recursive preOrder using HashMap
class Solution {
    private Map<Integer, List<Integer>> map;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        map=new HashMap<>();
        LinkedList<List<Integer>> list = new LinkedList<>();
        int depth = preOrder(root,0);
        for(int i=0;i<=depth;i++)
            list.addFirst(map.get(i));
        return list;
    }
    private int preOrder(TreeNode root,int d){
        if(root==null)return d-1;
        if(!map.containsKey(d))map.put(d,new ArrayList<>());
        map.get(d).add(root.val);
        return Math.max(preOrder(root.left , d+1),
        preOrder(root.right , d+1));
    }
}
// approach 3 : recursive using preOrder without HashMap
class Solution {
    private List<List<Integer>> list;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        list = new ArrayList<>();
        dfs(root,0);
        reverse();
        return list;
    }
    private void dfs(TreeNode root , int d){
        if(root==null)return;
        if(list.size()<d+1)list.add(d,new ArrayList<>());
        list.get(d).add(root.val);
        dfs(root.left,d+1);
        dfs(root.right,d+1);
    }
    private void reverse(){
        int l = 0;
        int r = list.size()-1;
        while(l<r){
            List<Integer> t = list.get(l);
            list.set(l,list.get(r));
            list.set(r,t);
            l++;r--;
        }
    }
}
