// time O(N) , space O(N)
/*  approach :
    
    --> suppose nodes are numbered as level wise :
                                    1               
                                /       \
                               2          3
                             /   \      /    \
                            4     5     6     7
                           / \   / \   / \   / \
                          8   9 10 11 12 13 14 15
                          
                          if some of nodes are null :
                          
                                    1
                                /       \
                               2          3
                             /   \          \
                            4     5          7
                           / \              / \
                          8   9            14 15
  --> upon observation we can see that from a current node number, 2*number +1 will lead to node on right and 2*number will lead to node on left.
  --> it will not cause any effect if some of nodes between leftmost and rightmost node are null .
  --> after numbering we can see that leftmost node has lowest number and rightmost node has highest number for a particular level
  --> then we can find total number of nodes in a level by rightmost node number - leftmost node number +1
  
*/
class Solution {
    Map<Integer,Long[]> map;
    public int widthOfBinaryTree(TreeNode root) {
        map =new HashMap<>();
        find(root,0,1L);
        int res=0;
        for(int ele : map.keySet()){
            Long[] x = map.get(ele);
            res = (int)Math.max(res,x[1]-x[0]);
        }
        return res+1;
            
    }
    private void find(TreeNode root,int x,long y){
        if(root==null)return;
        if(!map.containsKey(x))map.put(x,new Long[]{y,y});
        map.get(x)[0] = Math.min(map.get(x)[0],y);
        map.get(x)[1] = Math.max(map.get(x)[1],y);
        find(root.left,x+1,y*2);
        find(root.right,x+1,y*2+1);
    }
}
