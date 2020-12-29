//recursive and slower solution , took 1500 millisec
/*  approach :
      --> there are 2 possiblties , either we can rob a node or not (determined by isRobbed)
      --> if we can rob the current node (if isRobbed =true) , 
            -->either we can rob the current node and can't rob the left and right node
            -->or we can skip current node and can rob left and right node
            --> find both possiblities and return max of both
      --> if we can not rob current node , rob the left and right node and return their sum
*/
class Solution {
    int res;
    public int rob(TreeNode root) {
        res=0;
        find(root,true);
        return res;
    }
    private int find(TreeNode root,boolean isRobbed){
        if(root==null)return 0;
        if(isRobbed){
            int x = root.val + find(root.left,false)+find(root.right,false);
            int y = find(root.left,true) + find(root.right,true);
            res = Math.max(res,Math.max(x,y));
            return Math.max(x,y);
        }
        else{
            int x = find(root.left,true)+find(root.right,true);
            res = Math.max(res,x);
            return x;
        }
    }
}
// to improve the speed , we can apply dp to above recursive program and get 3 millisec solution
class Solution {
    int res;
    Map<TreeNode,Integer[]> map;
    public int rob(TreeNode root) {
        res=0;
        map = new HashMap<>();
        find(root,true);
        return res;
    }
    private int find(TreeNode root,boolean isRobbed){
        if(root==null)return 0;
        if(map.containsKey(root)){
            if(isRobbed && map.get(root)[0]!=-1)return map.get(root)[0];
            if(!isRobbed && map.get(root)[1]!=-1)return map.get(root)[1];
        }
        if(isRobbed){
            int x = root.val + find(root.left,false) + find(root.right,false);
            int y = find(root.left,true) + find(root.right,true);
            if(!map.containsKey(root))map.put(root,new Integer[]{-1,-1});
            res = Math.max(res,Math.max(x,y));
            return map.get(root)[0] = Math.max(x,y);
        }
        else{
           int x = find(root.left,true)+find(root.right,true);
            if(!map.containsKey(root))map.put(root,new Integer[]{-1,-1});
            res = Math.max(res,x);
            return map.get(root)[1] = x;
        }
    }
}
// another dp solution 
/*
    --> we can have a 2 element array , first element represent the node is robbed and 2nd element is node is not robbed
    --> for more details refer : https://leetcode.com/problems/house-robber-iii/solution/
*/
class Solution {
    public int rob(TreeNode root) {
        int[] res = find(root);
        return Math.max(res[1],res[0]);
    }
    private int[] find(TreeNode root){
        if(root==null)return new int[]{0,0};
        int[] l = find(root.left);
        int[] r = find(root.right);
        int[] curr = new int[]{0,0};
        int x = root.val + l[1]+r[1];
        int y = l[0] + r[0];
        curr[0] = Math.max(x,y);
        curr[1] = y;
        return curr;
    }
}
