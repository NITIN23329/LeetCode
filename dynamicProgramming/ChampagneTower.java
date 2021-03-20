// time and space complexity : O(query_row * query_row)
/*
  approach :
    let say we are glass represented by row'th row and and col'th column.
    if we have more champagne than a glass can hold, it will overflow half to glass at row+1'th row and col'th column and  half to glass at row+1'th row and col+1'th column.
    if we dont have a overflow, we will fill that glass with 0 wine.
    
*/
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row+1][query_row+1];
        dp[0][0] = poured;
        for(int row = 0; row<query_row;row++)
            for(int col = 0;col<=row;col++){
                dp[row+1][col] += Math.max(0,(dp[row][col]-1)/2d);
                dp[row+1][col+1] += Math.max(0,(dp[row][col]-1)/2d);
            }
        return Math.min(1,dp[query_row][query_glass]);    
    }
}
//time complexity : O(query_row * query_row) and space complexity : O(query_row)
/*
  the space complexity can be reduced to O(query_row) cuz a triangle is generated.
  let dp[j] = { answer for current row and jth column  , answer for next row and jth column}
  to calculate answer for i+1th row, we need answer of ith row.
  for every row iteration as we will calculate answer for next row, we will store answer of next row columns in dp[j][1] so that current row columns dp[j][0] do get affected.
  after processing all columns of particular row, we will move to next row, so we will bring the answer in dp[i][1] to dp[i][0].
*/
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row+1][2];
        dp[0][0] = poured;
        for(int row = 0; row<query_row;row++){
            for(int col = 0;col<=row;col++){
                dp[col][1] += Math.max(0,(dp[col][0]-1)/2d);
                dp[col+1][1] += Math.max(0,(dp[col][0]-1)/2d);
            }
            for(int col=0;col<=row+1;col++){
                dp[col][0] = dp[col][1];
                dp[col][1] = 0;
            }
        }
        return Math.min(1,dp[query_glass][0]);    
    }
}
