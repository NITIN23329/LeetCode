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
// time complexity O(n^2) and space complexity O(n)
// we can observe that the BST with node value [5,6,7] and [1,2,3] is same
// actually l....r value does not matter , what matter is the interval i.e. r-l
// for a particular i in range 1 to n ,consider i as root node, find # of ways to create left subtree(1..i-1) ,find # of ways to create right subtree(i+1...n)
// total # of ways to create BST with i as root node = # of left subtree * # of right subtree
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return memoHelper(n,dp);
    }
    private int memoHelper(int n,int[] dp){
        if(n==0)return 1;
        if(dp[n]!=-1)return dp[n];
        int ans = 0;
        for(int i=1;i<=n;i++)
            ans+= memoHelper(i-1,dp) * memoHelper(n-i,dp);
        return dp[n] = ans;
    }
}
