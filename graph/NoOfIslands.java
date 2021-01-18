// time O(nm)
// do a bfs/dfs as soon as we find '1' in grid and count # of times we did bfs/dfs
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(grid[i][j]=='1'){
                     dfs(grid,i,j,n,m);
                    islands++;
                }
        return islands;              
    }
    private void dfs(char[][] grid,int x,int y,int n,int m){
        grid[x][y]='0';
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        for(int i=0;i<4;i++)
            if(isValid(grid,x+dx[i],y+dy[i],n,m))
                dfs(grid,x+dx[i],y+dy[i],n,m);
    }
    private boolean isValid(char[][] grid,int x,int y,int n,int m){
        return x>=0 && y>=0 && x<n && y<m && grid[x][y]=='1';
    }
}
