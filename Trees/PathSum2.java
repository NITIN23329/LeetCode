//time O(n + h*logn)
/*  approach :
    --> find all paths from leaf to root,
    --> add current root node
    --> if current root node is a leaf and that  path leads to sum then add it to our answer
    --> recursively goto left and right subtree
    --> remove the added root node
  
    --. remove 
*/
class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        list = new ArrayList<>();
        find(root,sum,new LinkedList<>());
        return list;
    }
    private void find(TreeNode root,int sum,LinkedList<Integer> curr){
        if(root==null)return ;
        curr.add(root.val);
        sum-=root.val;
        if(root.left==null && root.right==null){
            if(sum==0){
                List<Integer> ll = new ArrayList(curr);
                list.add(ll);
            }
        }
        find(root.left,sum,curr);
        find(root.right,sum,curr);
        curr.removeLast();
    }
}
