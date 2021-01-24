// time O(nm)
/*  approach :
      --> do a dfs
      --> if the cell is at either edges then change its color
      --> if any adjacent cell which is not visited yet has a diff color then change current cell color.
*/
class Solution {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int n = grid.length; int m = grid[0].length;
        dfs(grid,n,m,r0,c0,color,grid[r0][c0],new boolean[n][m]);
        return grid;
    }
    private void dfs(int[][] grid,int n,int m,int x,int y,int nc,int pc,boolean[][] isVisited){
        isVisited[x][y] = true;
        if(x==0 || x==n-1 || y==0 || y==m-1)grid[x][y] = nc;
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};         
        for(int i=0;i<4;i++)
            if(isValid(x+dx[i],y+dy[i],n,m,isVisited))
                if(grid[x+dx[i]][y+dy[i]]==pc)
                    dfs(grid,n,m,x+dx[i],y+dy[i],nc,pc,isVisited);
                else  grid[x][y] = nc;
    }
    private boolean isValid(int x,int y,int n,int m, boolean[][] isVisited){
            return x>=0 && y>=0 && y<m && x<n && !isVisited[x][y];
    }
}
