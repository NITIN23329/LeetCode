// time complexity: O(4^n) = > loose bound
/*
    --> approach :
    --> try out all possible combiantions of placing a tile if
        --> both rows are of same length
        --> both row differ by 1 length
*/
class Solution {
    int mod = (int)1e9+7;
    public int numTilings(int n) {
        return (int)recursiveHelper(0,0,n);
    }
    private long recursiveHelper(int i,int j,int n){
        if(i==n && j==n)return 1L;
        if(i>=n || j>=n)return 0L;
        long ans = 0;
        if(i==j){
            ans = (ans + recursiveHelper(i+1,j+1,n))%mod;
            ans = (ans + recursiveHelper(i+2,j+2,n))%mod;
            ans = (ans + recursiveHelper(i+1,j+2,n))%mod;
            ans = (ans + recursiveHelper(i+2,j+1,n))%mod;
        }else{
            if(i==j+1){
                ans = (ans + recursiveHelper(i,j+2,n))%mod;
                ans = (ans + recursiveHelper(i+1,j+2,n))%mod;
            }
            else {
                ans = (ans + recursiveHelper(i+2,j,n))%mod;
                ans = (ans + recursiveHelper(i+2,j+1,n))%mod;
            }
        }
        return ans; 
    }
}
// memoization of above solution with time complexity O(n^2) 
// the memoHelper() is O(n) as we call functions for i-1,i,i+1, this can be verified from dp table after result calcualtion.
// but the dp initialization took O(n^2) time. Hence  we need to remove dp initialization.
// we used boolean [][] 2D array to check if result is calculated for i , j or we can use Map also
// over all time complexity O(n) and space complexity O(n^2)
class Solution {
    int mod = (int)1e9+7;
    public int numTilings(int n) {
        long[][] dp = new long[n][n];
        boolean[][] isSolved = new boolean[n][n];
        return (int)memoHelper(0,0,n,dp,isSolved);
    }
    private long memoHelper(int i,int j,int n,long [][] dp, boolean[][] isSolved ){
        if(i==n && j==n)return 1L;
        if(i>=n || j>=n)return 0L;
        if(isSolved[i][j])return dp[i][j];
        long ans = 0;
        if(i==j){
            ans = (ans + memoHelper(i+1,j+1,n,dp,isSolved))%mod;
            ans = (ans + memoHelper(i+2,j+2,n,dp,isSolved))%mod;
            ans = (ans + memoHelper(i+1,j+2,n,dp,isSolved))%mod;
            ans = (ans + memoHelper(i+2,j+1,n,dp,isSolved))%mod;
        }else{
            if(i==j+1){
                ans = (ans + memoHelper(i,j+2,n,dp,isSolved))%mod;
                ans = (ans + memoHelper(i+1,j+2,n,dp,isSolved))%mod;
            }
            else {
                ans = (ans + memoHelper(i+2,j,n,dp,isSolved))%mod;
                ans = (ans + memoHelper(i+2,j+1,n,dp,isSolved))%mod;
            }
        }
        isSolved[i][j] = true;
        return dp[i][j] = ans; 
    }
}
