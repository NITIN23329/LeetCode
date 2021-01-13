//time complexity : O(2*n*m) 
// do a dfs for row and column 
class Solution {
    public int countServers(int[][] grid) {
        int c = 0;
        int n = grid.length,m = grid[0].length;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(grid[i][j]==1){
                    int x = dfs(grid,i,j,n,m);
                    if(x!=1)c+=x;
                }
        return c;       
    }
    private int dfs(int[][] grid,int x,int y,int n,int m){
        grid[x][y]=0;
        int c=1;
        for(int i=0;i<n;i++)
            if(grid[i][y]==1)
                c+=dfs(grid,i,y,n,m);
        for(int j=0;j<m;j++)
            if(grid[x][j]==1)
                c+=dfs(grid,x,j,n,m);
        return c;
    }
}
