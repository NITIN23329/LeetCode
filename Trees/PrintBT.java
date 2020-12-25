/*
  approach : 
  --> upon observation, the height = rows , 2^height - 1  = col
  --> root node start with the mid of columns
  --> let say the index of root node is ith row and jth column , then the  initial gap = 2^(height-2)
  --> for left node we goto i+1 th row and j-gap th column where gap is reducing by 2 for every increment in level.
  --> for right node, we got i+1th row and j+gap th column where gap is reducing by 2 for every increment in level.
  
*/
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = findHeight(root);
        List<List<String>> list = new ArrayList<>(height);
        int col = (int)Math.pow(2,height)-1;
        for(int i=0;i<height;i++){
            List<String> level = new ArrayList<>();
            for(int j=0;j<col;j++)
                level.add("");
            list.add(level);
        }
        form(root,list,(int)Math.pow(2,height-2),col/2,0);
        return list;
        
    }
    private int findHeight(TreeNode root){
        if(root==null)return 0;
        return 1 + Math.max(findHeight(root.left),findHeight(root.right));
    }
    private void form(TreeNode root,List<List<String>> list,int gap,int curr,int level){
        if(root==null)return;
        list.get(level).set(curr,root.val+"");
        form(root.left,list,gap/2,curr-gap,level+1);
        form(root.right,list,gap/2,curr+gap,level+1);
        
    }
}
