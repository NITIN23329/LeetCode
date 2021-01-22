// time complexity O(nm) , space complexity O(1) excluding recursive stack
// approach : do a dfs on adj matrix and find # of disconnected components.
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int c=0;
        int n = isConnected.length;int m = isConnected[0].length;
        for(int i=0;i<n;i++){
            if(dfs(i,isConnected,n,m))c++;
        }
        return c;
    }
    private boolean dfs(int x,int[][] grid,int n,int m){
        boolean ans =false;
        for(int j=0;j<m;j++){
             if(grid[x][j]==1){
                  grid[x][j]=0;
                  grid[j][x]=0;
                  dfs(j,grid,n,m);
                 ans = true;
             }
        }
        return ans;
    }
}
