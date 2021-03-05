// recursive solution with time complexity O(2^(nm))
/*
  approach :
      --> Note we need atleast an initial health of 1 to start 
      --> suppose we are at cell{x,y} , we will try to find the minimum need of extra health to goto from cell{x,y} to cell{n-1,m-1}
      --> as we have 2 choices, to go from cell{x,y} to cell{x+1,y} or cell{x,y+1}
      --> we will find the need of cell{x+1,y} and cell{x,y+1} using recursive calls.
      --> which cell we want to go next ? whose need is less.(note need will be represented by -ve number)
      --> if the cell{x,y} is able to fullfill the need of the next cell , then we dont need any extra health so return 0
      --> other wise return the need of cell{x,y}.
*/
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        return -recursiveHelper(dungeon,0,0,dungeon.length,dungeon[0].length)+1;
    }
    private int recursiveHelper(int[][] grid,int x,int y,int n,int m){
        if(x==n-1 && y==m-1)return Math.min(0,grid[x][y]);
        int c1 = x+1==n ? Integer.MIN_VALUE : recursiveHelper(grid,x+1,y,n,m);
        int c2 = y+1==m ? Integer.MIN_VALUE : recursiveHelper(grid,x,y+1,n,m);
        return Math.min(0,grid[x][y] + Math.max(c1,c2));
    }
}
// memoization of above recursive soltuion with time and space complexity O(nm)
// note that the initiallisation is done with 1 as need is always <=0.
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon[0].length;
        int n = dungeon.length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],1);
       return -memoHelper(dungeon,0,0,n,m,dp)+1;
    }
    private int memoHelper(int[][] grid,int x,int y,int n,int m,int[][] dp){
        if(x==n-1 && y==m-1)return Math.min(0,grid[x][y]);
        if(dp[x][y]!=1)return dp[x][y];
        int c1 = x+1==n ? Integer.MIN_VALUE : memoHelper(grid,x+1,y,n,m,dp);
        int c2 = y+1==m ? Integer.MIN_VALUE : memoHelper(grid,x,y+1,n,m,dp);
        return dp[x][y] = Math.min(0,grid[x][y]+Math.max(c1,c2));
    }
}
