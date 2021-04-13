// time complexity : O(nm). space complexity : O(1)
/*
  approach :
    --> We want to maximize the ones at left side of the matrix.
    --> The first thing to observe is that if for a row, first column element is 0, toggle that row. Why not column? (Toggling row will ensure 1st column have only 1).
    --> Then for all other column, if zeroCount > oneCount then toggle that column (WHy not row? toggling row will toggle our 1st col 1 and we dont want that)
*/
class Solution {
    public int matrixScore(int[][] A) {
        // for 1st column toggle those row's whose 1st column element  = 1;
        int n = A.length,m = A[0].length;
        for(int i=0;i<n;i++)
            if(A[i][0]==0){
                for(int j=0;j<m;j++)A[i][j] = A[i][j]==1?0:1;
            }
        // for col = 1 to m-1, toggle those columns whose 0 count > 1 count. 
        for(int j=1;j<m;j++){
            int oneCount = 0;
            for(int i=0;i<n;i++)
                oneCount += A[i][j];
            int zeroCount = n - oneCount;
            if(zeroCount>oneCount){
                for(int i=0;i<n;i++)A[i][j] = A[i][j]==1?0:1;
            }
        }
        // coverting binary to decimal
        int ans = 0;
        for(int i=0;i<n;i++){
            int curr = 0;
            for(int j=m-1;j>=0;j--)
                curr += A[i][j]<<(m-1-j);   // or we can use A[i][j] * Math.pow(2,m-1-j)
            ans += curr;
        }
        return ans;
    }
}
