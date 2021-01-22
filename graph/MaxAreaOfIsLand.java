// time complexity O(nm)
// do a dfs and find maximum dfs
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        if(n==0)return 0;
        int m=grid[0].length;
        if(m==0)return 0;
        int max = 0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(grid[i][j]==1)
                    max = Math.max(max,dfs(grid,i,j,n,m));
        return max;
    }
    private int dfs(int[][] grid,int x,int y,int n,int m){
        grid[x][y] = 0;
        int c = 1;
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        for(int i=0;i<4;i++)
            if(isValid(x+dx[i],y+dy[i],grid,n,m))
                c+=dfs(grid,x+dx[i],y+dy[i],n,m);
        return c;
    }
    private boolean isValid(int x, int y,int[][] grid, int n,int m){
        return x>=0 && y>=0 && x<n && y<m && grid[x][y]==1;
    }
}
