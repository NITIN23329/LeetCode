// time O(n*n!) , space O(n!)
/*  approach :
      --> for a given value of 1...n , find all permutation of numbers of 1..n  and store it in arrays
      --> for each permutation, assue it as a preorder and from a BST from that perorder
      --> one corner cases is some of the permutations can not be a pre order traversal of any BST like [2,3,1]
      --> for those, all n nodes are not created in the tree.
*/
class Solution {
    List<List<Integer>> permu;
    List<TreeNode> trees;
    public List<TreeNode> generateTrees(int n) {
        permu = new ArrayList<>();
        findPermutation(new ArrayList<>(),n);
        trees = new ArrayList<>();
        if(n==0)return trees;
        for(List<Integer> preorder : permu){
            int[] index = new int[1];
             TreeNode root = findTree(preorder,index,1,n);
            if(index[0]==preorder.size())trees.add(root);
        }
           
        return trees;
    }
    private void findPermutation(List<Integer> curr , int n){
        if(curr.size()==n){
            permu.add(curr);
            return;
        }
        for(int i=1;i<=n;i++){
            int j=0;
            for(j=0;j<curr.size();j++)
                if(curr.get(j)==i)break;
            if(j==curr.size()){
                List<Integer> t = new ArrayList<>(curr);
                t.add(i);
                findPermutation(t,n);
            }
        }
    }
    private TreeNode findTree(List<Integer> pre ,int[] index,int l,int r){
        if(index[0]==pre.size())return null;
        TreeNode root = new TreeNode(pre.get(index[0]));
        if(root.val<l || root.val>r)return null;
        index[0]++;
        root.left = findTree(pre,index,l,root.val-1);
        root.right = findTree(pre,index,root.val+1,r);
        return root;
    }
}
// falster than above solution
/*
  approach :
  -->for every possible i in low to high , 
  -->find all possible combinations of right(i+1,high) and left(low,i-1) subtree and find all trees with i as root
*/
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0)return new ArrayList<>();
        return findTrees(1,n);
    }
    private List<TreeNode> findTrees(int low,int high){
        List<TreeNode> list = new ArrayList<>();
        if(low>high){
            list.add(null);
            return list;
        }
       
        for(int i=low;i<=high;i++){
            List<TreeNode> l = findTrees(low,i-1);
            List<TreeNode> r = findTrees(i+1,high);
            
            for(TreeNode ll:l)
                for(TreeNode rr:r){
                    TreeNode root = new TreeNode(i);
                    root.left = ll;
                    root.right = rr;
                    list.add(root);
                }
        }
        return list;
        
    }
}
