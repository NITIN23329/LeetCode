/*  approach :
      -->solution is similar to problem UNIQUE BST2
                 -->PROBLEM : https://leetcode.com/problems/unique-binary-search-trees-ii/
                 --> SOLUTION : https://github.com/NITIN23329/LeetCode/blob/ff41c028cdce8459abf8f04d473727397a675a53/Trees/UniqueBST2.java#L51
      --> for every node (i) in l to r
      --> find all possible left and right subtree
      --> for a particular node i , # of left subtree *  # of right subtree is the total # of trees having ndoe as root.
      --> find sum of all node (i) 
*/
//slower recursive solution [TLE]
class Solution {
    public int numTrees(int n) {
         return find(1,n);
    }
    private int find(int l,int r){
        if(l>r)return 1;
        int res=0;
        for(int i=l;i<=r;i++){
            int left = find(l,i-1);
            int right = find(i+1,r);
            res+=left*right;
        }
        return res;
    }
}
// dp of above recursive solution [ACCEPTED]
class Solution {
    public int numTrees(int n) {
        int[][] dp=new int[n+2][n+2];
        for(int i=0;i<n+2;i++)
            for(int j=0;j<n+2;j++)dp[i][j]=-1;
         return find(1,n,dp);
    }
    private int find(int l,int r,int[][] dp){
        if(l>r)return 1;
        int res=0;
        for(int i=l;i<=r;i++){
            if(dp[l][i-1]==-1)
                dp[l][i-1] = find(l,i-1,dp);
            int left = dp[l][i-1];
            if(dp[i+1][r]==-1)
                dp[i+1][r]=find(i+1,r,dp);
            int right = dp[i+1][r];
            res+=left*right;
        }
        return res;
    }
}
