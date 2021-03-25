// time and space complexity : O(nm)
/*
  approach : for every cell, keep hold of maximum +ve product and maximum -ve product to reach from 0,0 to that particular cell
  --> Why so? suppose product to reach an adjucent(upper cell or left cell) of cell is -ve and current cell is -ve, then total product is +ve
  --> suppose product to reach an adjucent(upper cell or left cell) of cell is +ve and current cell is +ve, then total product is +ve
  --> Hence keep hold of max product for both signs.
*/
class Solution {
    public int maxProductPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        long[][] maxPos = new long[n][m];
        long[][] maxNeg = new long[n][m];
        boolean isZero = grid[0][0]==0?true : false;
        if(grid[0][0]>=0)maxPos[0][0] = grid[0][0];
        else maxNeg[0][0] = grid[0][0];
        
        for(int i=1;i<n;i++)
            if(grid[i][0]>0){
                maxPos[i][0] = maxPos[i-1][0] * grid[i][0];
                maxNeg[i][0] = maxNeg[i-1][0] * grid[i][0];
            }else if(grid[i][0]<0){
                maxPos[i][0] = maxNeg[i-1][0] * grid[i][0];
                maxNeg[i][0] = maxPos[i-1][0] * grid[i][0];
            }else isZero = true;
        for(int j=1;j<m;j++)
            if(grid[0][j]>0){
                maxPos[0][j] = maxPos[0][j-1] * grid[0][j];
                maxNeg[0][j] = maxNeg[0][j-1] * grid[0][j];
            }else if(grid[0][j]<0) {
                maxPos[0][j] = maxNeg[0][j-1] * grid[0][j];
                maxNeg[0][j] = maxPos[0][j-1] * grid[0][j];
            }else  isZero = true;
        
        for(int i=1;i<n;i++)
            for(int j=1;j<m;j++){
                if(grid[i][j]>0){
                    maxPos[i][j] = Math.max(maxPos[i][j-1],maxPos[i-1][j])*grid[i][j];
                    maxNeg[i][j] = Math.min(maxNeg[i][j-1],maxNeg[i-1][j])*grid[i][j];
                }else if(grid[i][j]<0){
                    maxPos[i][j] = Math.min(maxNeg[i][j-1],maxNeg[i-1][j])*grid[i][j];
                    maxNeg[i][j] =  Math.max(maxPos[i][j-1],maxPos[i-1][j])*grid[i][j];
                }else  isZero = true;
            }
        int mod = (int)1e9+7;
        if(isZero)
            return maxPos[n-1][m-1]>=0? (int)(maxPos[n-1][m-1]%mod) : -1;
        return maxPos[n-1][m-1]>0? (int)(maxPos[n-1][m-1]%mod) : -1;
    }
}
