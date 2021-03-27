// time and space complexity : O(n*n)
/*
  approach :
    --> we have 3 choices: up or left or diagonal.
    --> if we reach at cell{0,0}, we return [0,1]. It means we have 1 path and sum is 0 cuz it represents end point.
    --> if cell{x,y} == 'X' or we are out of grid, we return {0,0}. It means we have 0 path to goto cell{0,0} and sum is 0 as well.
    --> out of 3 possible option, we take that which have maximum sum and have a path(c[1]>0) and we find sum of all possible path to get the maximum sum.
    --> after this, we add our current grid value and we store a copy of this answer in dp and we return another copy .
    --> for getting answer from dp, we return a copy cuz if we return dp[x][y] simple, we give reference, And as ans[] changes, that answer in dp will also change and hene we get incorrect result.
*/
class Solution {
    int mod = (int)1e9+7;
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        long[][][] dp = new long[n][n][2];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dp[i][j] = new long[]{-1,-1};
        long[] ans = helper(board,n-1,n-1,dp);
        return new int[]{(int)ans[0],(int)ans[1]};
    }
    private long[] helper(List<String> grid,int x,int y,long[][][] dp){
        if(x==0 && y==0)return new long[]{0,1};
        if(x<0 || y<0)return new long[]{0,0};
        char ch = grid.get(x).charAt(y);
        if(ch=='X')return new long[]{0,0};
        if(dp[x][y][1]!=-1)return copy(dp[x][y]);
        long[] c1 = helper(grid,x-1,y-1,dp);
        long[] c2 = helper(grid,x-1,y,dp);
        long[] c3 = helper(grid,x,y-1,dp);
        long[] ans  = new long[2];
        ans = addUp(ans,c1);
        ans = addUp(ans,c2);
        ans = addUp(ans,c3);
        if(ch!='S')ans[0] += (ch-'0');
        ans[1] = (ans[1])%mod;
        dp[x][y] = copy(ans);
        return copy(ans);
    }
    private long[] addUp(long[] ans,long[] c){
        if(c[1]>0){
            if(c[0]>ans[0])return c;
            else if(c[0]==ans[0]) ans[1]+=c[1];
        }
        return ans;
    }
    private long[] copy(long[] ans){
        return new long[]{ans[0],ans[1]};
    }
}
