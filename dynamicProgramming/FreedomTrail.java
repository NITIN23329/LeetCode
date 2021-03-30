// time complexity : O(m*n*n) and space complexity O(nm) where m = key.length() and n = ring.length()
/*
  approach :
    --> for a character in key, we can move the trail clockwise or anticlockwise .
    --> we find min steps required to move the trail to get character for both case and return min of both.
*/
class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
        return helper(key,0,ring,0,n,dp);
    }
    private int helper(String key,int i,String ring,int j,int n,int[][] dp){
        if(i==key.length())return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int right = j;
        int rightCount = 0;
        while(key.charAt(i)!=ring.charAt(right)){
            right++;
            if(right==n)right = 0;
            rightCount++;
        }
        int left = j;
        int leftCount = 0;
        while(key.charAt(i)!=ring.charAt(left)){
            left--;
            if(left==-1)left = n-1;
            leftCount++;
        }
        int c1 = rightCount + helper(key,i+1,ring,right,n,dp);
        int c2 = leftCount + helper(key,i+1,ring,left,n,dp);
        return dp[i][j] = 1 + Math.min(c1,c2);
    }
}
