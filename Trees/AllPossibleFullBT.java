//approach :    
/*  -->solution is similar to problem UNIQUE BST2
                -->PROBLEM : https://leetcode.com/problems/unique-binary-search-trees-ii/
                --> SOLUTION : https://github.com/NITIN23329/LeetCode/blob/ff41c028cdce8459abf8f04d473727397a675a53/Trees/UniqueBST2.java#L51
    --> if N is even we can not form a full BT
    --> suppose we are given N to be 5 --> [0,0,0,0,0] l =1 , r=5
    --> we can start from l+1 to r-1 ,increment by 2 as we can create either 0 ot 2 nodes at a time.
    --> and if we start from l, then there is no left subtree possible which can not happen in Full BT,similarly we go untill r-1
    -->we found all possible left and right subtree
    --> for every subtree , we create a root node and link it to every left and right subtree and add it to our result
    --> if l+1>r-1 , it will lead to a tree having only 1 left node
*/
class Solution {
    public List<TreeNode> allPossibleFBT(int N) {
        if(N%2==0)return new ArrayList<>();
        return form (1,N);
    }
    private List<TreeNode> form(int l,int r){
        if(l+1>r-1){
            List<TreeNode> res = new ArrayList<>();
            res.add(new TreeNode(0));
            return res;
        }
        List<TreeNode> res = new ArrayList<>();
        for(int i=l+1;i<=r-1;i+=2){
            List<TreeNode> ll = form(l,i-1);
            List<TreeNode> rr = form(i+1,r);
            for(TreeNode lll:ll){
                for(TreeNode rrr:rr){
                    TreeNode root = new TreeNode(0);
                    root.left=lll;
                    root.right=rrr;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
