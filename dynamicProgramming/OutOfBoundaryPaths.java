// time complexity and space complexity : O(n*m*k)
/*  approach 1 : recursive solution
        --> do a dfs
        --> at every cell , we can go either left,right,up or down.
        --> if we reach out of boundary return 1.
        --> if we are out of k(steps) i.e. k==0 return 0 as we didn't reached out of boundary.
*/
class Solution {
    private int mod;
    public int findPaths(int n, int m, int k, int i, int j) {
        mod = (int)1e9+7;
        return dfs(i,j,n,m,k);
    }
    private int dfs(int x,int y,int n, int m, int k){
        if(x==-1 || y==-1 || x==n || y==m)
            return 1;
        if(k==0)return 0;
        int c = 0;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};
        for(int i=0;i<4;i++)
            c = (c+dfs(x+dx[i],y+dy[i],n,m,k-1))%mod;
        return c;
    }
}
/*  approach 2 : memomization of above solution
      --> the state of dp is x,y and k (all changing variables)
      --> create a dp array of 3 dimensions, fill with -1
      --> find ans for a particular (x,y,k) and save in dp[x][y][k]
*/
class Solution {
    private int mod;
    public int findPaths(int n, int m, int k, int i, int j) {
        mod = (int)1e9+7;
        int[][][] dp = new int[n][m][k+1];
        for(int a=0;a<n;a++)
            for(int b=0;b<m;b++)
                 Arrays.fill(dp[a][b],-1);
        return dfs(i,j,n,m,k,dp);
    }
    private int dfs(int x,int y,int n, int m, int k,int[][][] dp){
        if(x==-1 || y==-1 || x==n || y==m)
            return 1;
        if(k==0)return 0;
        if(dp[x][y][k]!=-1)return dp[x][y][k];
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};
        int c = 0;
        for(int i=0;i<4;i++)
             c = (c+ dfs(x+dx[i],y+dy[i],n,m,k-1,dp))%mod;
        return dp[x][y][k] = c;
    }
}

