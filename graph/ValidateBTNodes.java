// time O(n)
/*  approach :
      --> form binary tree out of given left and right child array
      --> do a tree traversal and check for valid biary tree.
      --> how to find root node?  
          -->assume root node to be 0 initially, during formation of tree if current node's left/right child is 0 then new root will be current node and so on.
      --> after finding proper root, traverse the tree
      -->during traversal if we found any visited node,then it means there is a back edge from decendant to ancestors,return false.
      --> after traversal check if any node from 0 to n-1 is not visited, if not the. tree is disconnect and return false
*/
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer,TreeNode> map = new HashMap<>();
        for(int i=0;i<n;i++)map.put(i,new TreeNode(i));
        TreeNode  root = map.get(0);  //initially assume root to be node 0
        for(int i=0;i<n;i++){
            TreeNode x = map.get(i);
            if(leftChild[i]!=-1){
                x.left = map.get(leftChild[i]);
                if(leftChild[i]==root.data)root=x;  // update  root if any
            }
            if(rightChild[i]!=-1){
                x.right = map.get(rightChild[i]);
                if(rightChild[i]==root.data)root = x;   //update root if any 
            }
        }
        boolean[] isVisited = new boolean[n];
        if(!preOrder(root,isVisited))return false;
        for(boolean ele : isVisited)if(!ele)return false;
        return true;
    }
    private boolean preOrder(TreeNode root,boolean[] isVisited ){
        if(root==null)return true;
        if(isVisited[root.data])return false;
        isVisited[root.data] = true;
        return preOrder(root.left,isVisited) && preOrder(root.right,isVisited);
    }
}
class TreeNode{
    int data;
    public TreeNode(int data){
        this.data = data;
    }
    TreeNode left;
    TreeNode right;
}
