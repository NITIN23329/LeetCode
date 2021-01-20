// time complexity O(n^2)
// check for all possible combinations.
class Solution {
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;int m = grid[0].length;
        return dfs(0,0,-1,-1,grid,n,m,new boolean[n][m]);
    }
    private boolean dfs(int x,int y,int px,int py,int[][] grid,int n,int m,boolean[][] visited){
         visited[x][y] = true;
        if(x==n-1 && y == m-1)return true;
        boolean ans = false;   
        if(grid[x][y]==1){
            if(y+1!=py && y+1<m && !visited[x][y+1] && (grid[x][y+1]==3 || grid[x][y+1]==1 || grid[x][y+1]==5))
              ans = ans || dfs(x,y+1,x,y,grid,n,m,visited);
             if(y-1!=py && y-1>=0  && !visited[x][y-1] && (grid[x][y-1]==4 || grid[x][y-1]==1 || grid[x][y-1]==6))
              ans = ans || dfs(x,y-1,x,y,grid,n,m,visited);
        }
        else if(grid[x][y]==2){
            if(x+1!=px && x+1<n  && !visited[x+1][y] && (grid[x+1][y]==2 || grid[x+1][y]==5 || grid[x+1][y]==6))
               ans = ans || dfs(x+1,y,x,y,grid,n,m,visited);
            if (x-1!=px && x-1>=0 &&  !visited[x-1][y] && (grid[x-1][y]==2 || grid[x-1][y]==4 || grid[x-1][y]==3))
                 ans = ans || dfs(x-1,y,x,y,grid,n,m,visited);
        }
        else if(grid[x][y]==3){
            if(x+1!=px && x+1<n  && !visited[x+1][y] && (grid[x+1][y]==2 || grid[x+1][y]==6 || grid[x+1][y]==5))
               ans = ans || dfs(x+1,y,x,y,grid,n,m,visited);
             if(y-1!=py && y-1>=0  &&  !visited[x][y-1] &&(grid[x][y-1]==4 || grid[x][y-1]==1 || grid[x][y-1]==6))
                   ans = ans || dfs(x,y-1,x,y,grid,n,m,visited);
        }
        else if(grid[x][y]==4){
            if(x+1!=px && x+1<n  &&  !visited[x+1][y]&& (grid[x+1][y]==2 || grid[x+1][y]==6 || grid[x+1][y]==5))
               ans = ans || dfs(x+1,y,x,y,grid,n,m,visited);
             if(y+1!=py && y+1<m  &&  !visited[x][y+1]&& (grid[x][y+1]==3 || grid[x][y+1]==1 || grid[x][y+1]==5))
               ans = ans || dfs(x,y+1,x,y,grid,n,m,visited);
        }
        else if(grid[x][y]==5){
            if(x-1!=px && x-1>=0  &&  !visited[x-1][y]&& (grid[x-1][y]==3 || grid[x-1][y]==4 || grid[x-1][y]==2))
               ans = ans || dfs(x-1,y,x,y,grid,n,m,visited);
             if(y-1!=py && y-1>=0  &&  !visited[x][y-1] && (grid[x][y-1]==4 || grid[x][y-1]==1 || grid[x][y-1]==6))
               ans = ans || dfs(x,y-1,x,y,grid,n,m,visited);
        }
      else{
            if(x-1!=px && x-1>=0  &&  !visited[x-1][y]&& (grid[x-1][y]==3 || grid[x-1][y]==4 || grid[x-1][y]==2))
               ans = ans || dfs(x-1,y,x,y,grid,n,m,visited);
            if(y+1!=py && y+1<m  &&  !visited[x][y+1]&& (grid[x][y+1]==3 || grid[x][y+1]==1 || grid[x][y+1]==5))
               ans = ans || dfs(x,y+1,x,y,grid,n,m,visited);
        }
        return ans;
    }
}
