// time O(nm)
// do a dfs and check while dfs we reach a edge or not, if yes than it is not a closed island.
class Solution {
    boolean isClosed;
    public int closedIsland(int[][] grid) {
        int c = 0;
        int n = grid.length;int m = grid[0].length;
        for(int i=0;i<n;i++)
            for(int j = 0;j<m;j++)
                if(grid[i][j]==0){
                    isClosed = true;
                    dfs(grid,i,j,n,m);
                    if(isClosed)c++;
                }
                       
        return c;
    }
    private void dfs(int[][] grid,int x,int y,int n,int m){
        grid[x][y] = 1;
        if(x==0 || x==n-1 || y==0 || y==m-1)isClosed= false;
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        for(int i=0;i<4;i++)
            if(isValid(x+dx[i],y+dy[i],grid,n,m))
                dfs(grid,x+dx[i],y+dy[i],n,m);
    }
    private boolean isValid(int x,int y,int[][] grid,int n,int m){
        return x>=0 && y>=0 && x<n && y<m && grid[x][y]==0;
    }
}
