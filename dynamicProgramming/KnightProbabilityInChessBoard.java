// recursive solution
/*
  approach : here probability of cell i,j means the probability that the knight will still remains inside grid if it moves from cell i,j
    --> if we are out of grid,then probability is 0
    --> if k==0 , then we are out of moves while we are still inside grid hence probability is 1
    -->instead of finding probability of current step from previous step , we will do reverse of it I.e. we will find current probability from next probability.
    --> suppose when k reaches 0 and still we are inside grid at cell i,j , then probability of all 8 cells from which we reaches cell i,j is 1/8 and so on.
    --> as we have 8 possibilites to go from current cell to next cell, then the current probability += next probability/8
*/
class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        return recursiveHelper(r,c,N,K);
    }
    private double recursiveHelper(int x,int y,int n,int k){
        if(x<0 || y<0 || x>=n || y>=n)
            return 0d;
        if(k==0)
            return 1d;
        double in = 0d;
        int[] dx = {2,2,-2,-2,1,1,-1,-1};
        int[] dy = {-1,1,-1,1,2,-2,2,-2};
        for(int i=0;i<8;i++){
            double next = recursiveHelper(x+dx[i],y+dy[i],n,k-1);
            in+= next/8.0;
        }
        return in;
    }
}

// memoization of above recursive solution with time and space complexity : O(n*n*k)
class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[N][N][K+1];
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                Arrays.fill(dp[i][j],-1);
        return memoHelper(r,c,N,K,dp);
    }
    private double memoHelper(int x,int y,int n,int k,double[][][] dp){
        if(x<0 || y<0 || x>=n || y>=n)
            return 0d;
        if(k==0)
            return 1d;
        if(dp[x][y][k]!=-1)return dp[x][y][k];
        double in = 0d;
        int[] dx = {2,2,-2,-2,1,1,-1,-1};
        int[] dy = {-1,1,-1,1,2,-2,2,-2};
        for(int i=0;i<8;i++){
            double next = memoHelper(x+dx[i],y+dy[i],n,k-1,dp);
            in+= next/8.0;
        }
        return dp[x][y][k] = in;
    }
}
