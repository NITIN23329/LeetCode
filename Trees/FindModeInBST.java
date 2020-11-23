// approach 1 : maintain a hashmap to keep freq of all distinct value nodes , find all  maximum occured node
// time o(n) , space O(n).                                                                                 
class Solution {
    private Map<Integer,Integer> map;
    int maxf;
    public int[] findMode(TreeNode root) {
        map = new HashMap<>();
        maxf=0;
        freq(root);
        ArrayList<Integer> list = new ArrayList<>();
        for(int ele : map.keySet())
            if(map.get(ele)==maxf)
                list.add(ele);
        int[] arr = new int[list.size()];
        for(int i=0;i<list.size();i++)
            arr[i] = list.get(i);
        return arr;
            
    }
    private void freq(TreeNode root){
        if(root==null)return;
        if(!map.containsKey(root.val))map.put(root.val , 0);
        map.put(root.val, map.get(root.val)+1);
        maxf = Math.max(maxf,map.get(root.val));
        freq(root.left);
        freq(root.right);
    }
}
