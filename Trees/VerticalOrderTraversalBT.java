
// each node's position is reprdesnted by x,y where x =level,y = distance from root
// if y is same, then smaller x is added first. if x is also same then smaller node value is added first
class Solution {
    Map<Integer,List<Integer[]>> map;
    int l,r;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new HashMap<>();
        l=Integer.MAX_VALUE;
        r = Integer.MIN_VALUE;
        find(root,0,0);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=l;i<=r;i++){
            List<Integer[]> l = map.get(i);
            Collections.sort(l,new Comparator<>(){
                @Override
                public int compare(Integer[] o1,Integer[] o2){
                    if(o1[1]==o2[1]){
                        return o1[0]-o2[0];
                    }
                    return o1[1]-o2[1];
                }
            });
            List<Integer> ll = new ArrayList<>();
            for(Integer[] ele : l)
                ll.add(ele[0]);
            res.add(ll);
        }
        return res;
    }
    private void find(TreeNode root,int x,int y){
        if(root==null)return;
        if(!map.containsKey(y))map.put(y,new ArrayList<>());
        map.get(y).add(new Integer[]{root.val,x});
        l = Math.min(l,y);
        r = Math.max(r,y);
        find(root.left,x+1,y-1);
        find(root.right,x+1,y+1);
    }
}
// another short solution using sorted TreeMap

class Solution {
    TreeMap<Integer,TreeMap<Integer,List<Integer>>> map = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root,0,0);
        for(int col : map.keySet()){
            List<Integer> arr = new ArrayList<>();
            for(int row : map.get(col).keySet()){
                List<Integer> curr = map.get(col).get(row);
                Collections.sort(curr);
                arr.addAll(curr);
            }
            res.add(arr);
        }
        return res;
    }
    private void traverse(TreeNode root,int row,int col){
        if(root == null)return;
        if(!map.containsKey(col))map.put(col,new TreeMap<>());
        if(!map.get(col).containsKey(row))map.get(col).put(row,new ArrayList<>());
        map.get(col).get(row).add(root.val);
        traverse(root.left,row+1,col-1);
        traverse(root.right,row+1,col+1);
    }
}
