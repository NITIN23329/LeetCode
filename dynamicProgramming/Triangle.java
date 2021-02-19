// from i,j we have 2 choices to go down , either i+1,j or i+1,j+1
//time complexity of recursive code : O(2^(n*n)), where n is size of triangle
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return recursiveHelper(triangle,0,0);
    }
    private int recursiveHelper(List<List<Integer>> list,int i,int j){
        if(i==list.size())return 0;
        if(i+1!=list.size() && j+1 < list.get(i+1).size())
            return list.get(i).get(j) +Math.min(recursiveHelper(list,i+1,j+1),recursiveHelper(list,i+1,j));
        return list.get(i).get(j)+recursiveHelper(list,i+1,j);
    }
}
// memoization of recursive code , time and space complexity : O(n*(n+1)/2) = O(n^2)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int i=0;i<dp.length;i++)Arrays.fill(dp[i],-1);
        return memoHelper(triangle,0,0,dp);
    }
    private int memoHelper(List<List<Integer>> list,int i,int j,int[][] dp){
        if(i==list.size())return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(i+1!=list.size() && j+1 < list.get(i+1).size())
            return dp[i][j] = list.get(i).get(j) + 
            Math.min(memoHelper(list,i+1,j+1,dp),memoHelper(list,i+1,j,dp));
        return dp[i][j] = list.get(i).get(j)+memoHelper(list,i+1,j,dp);
    }
}
// time complexity : O(n^2) , space compelxity O(n)
/*
    --> as in above solutions, we went from top of trinagle to bottom of triangle
    --> now, we will go from bottom to top of triangle.
    --> initialization step :   path sum for last row element is element value itself
    --> to calculate path sum for triangle[i][j] , we find path sum of triangle[i+1][j] by dp[j] and triangle [i+1][j+1] by dp[j+1] 
      --> take min of both and add triangle[i][j] to get path sum of triangle[i][j] from bottom and store it in dp[j].
*/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.get(triangle.size()-1).size();
        int[] dp = new int[n];
        for(int i=0;i<n;i++)
            dp[i] = triangle.get(triangle.size()-1).get(i);
        for(int i=n-2;i>=0;i--)
            for(int j=0;j<triangle.get(i).size();j++)
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j],dp[j+1]);
        return dp[0];
    }
}
