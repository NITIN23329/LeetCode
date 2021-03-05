// approach 1 : using stack
// time complexity O(mn) , space complexity O(n) where m= # of row and n = # of columns 
// this solution can be done using the MAXIMAL SOLUTION APPROACH
//which can be solved using largest rectangle in a histogram solution
//Note : in case of maximal rectangle problem, we found area = height * width of largest rectangle for each i in 0 to n-1
//here we will find side = min(height,width), area = side*side for each i in 0 to n-1.
class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        int[] hist = new int[n];
        int ans = 0;
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++)
                hist[col] += matrix[row][col]=='1'? 1 : -hist[col];
            ans = Math.max(ans,histogram(hist,n));
        }
        return ans;
    }
    private int histogram(int[] hist,int n){
       int[] minRightIndex = new int[n];
       int[] minLeftIndex = new int[n];
       Deque<Integer> dq = new ArrayDeque<>();
       for(int i=n-1;i>=0;i--){
           while(!dq.isEmpty() && hist[dq.peek()]>=hist[i])
                dq.pop();
            minRightIndex[i] = dq.isEmpty()? n :dq.peek();
            dq.push(i);
       }
       dq = new ArrayDeque<>();
       for(int i=0;i<n;i++){
            while(!dq.isEmpty() && hist[dq.peek()]>=hist[i])
                dq.pop();
            minLeftIndex[i] = dq.isEmpty()? -1 : dq.peek();
            dq.push(i);
       }
       int ans = 0;
       for(int i=0;i<n;i++){
           int width = minRightIndex[i]-i+i-minLeftIndex[i]-1;
           int height = hist[i];
           int side = Math.min(width,height);
           ans = Math.max(ans,side*side);
       }
        return ans;
    }
}
// approach 2 : using dp
// solution link : https://www.youtube.com/watch?v=oPrpoVdRLtg&t=636s
/*
    approach :
        --> think of how to get current answer from its subproblem ...
        -->         1   1   1
                    1   1   1
                    1   1   1
        --> let say we want to find maximum side of a square end at cell{2,2} assuming we know answer for all other cells.
        --> cell{2,2} = 1 + min( cell{1,2} , cell{2,1} , cell{1,1}) 
        --> if the max side of square ending at cell{1,2} , cell{2,1} , cell{1,1} ==2 ,and matrix[2][2] == '1' , then  max side of square ending at cell{2,2} = 3
        --> if any cell from cell{1,2} , cell{2,1} , cell{1,1}==1 , then our answer would for cell{2,2} is 2
        --> if matrix[i][j] =='0' then no square can end at cell{i,j} then answer is 0.
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int side = 0;
        for(int r=0;r<n;r++){
            dp[r][0] = matrix[r][0] =='1' ? 1 : 0;
            side = Math.max(dp[r][0],side);    
        }
        for(int c=0;c<m;c++){
            dp[0][c] = matrix[0][c] == '1' ? 1 : 0;
            side = Math.max(dp[0][c],side);
        }
        for(int r=1;r<n;r++)
            for(int c=1;c<m;c++){
                if(matrix[r][c]=='0')dp[r][c] = 0;
                else dp[r][c] = 1 + Math.min(dp[r-1][c-1],Math.min(dp[r-1][c],dp[r][c-1]));
                side = Math.max(side,dp[r][c]);
            }
        return side*side;
    }
}
