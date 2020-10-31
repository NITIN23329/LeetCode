//time complexity O(n^2)
/* approach :
1)  for every row , find height for each element in that row.(height: no of consecutive 1 above that element)
2) for every row , find area of largest rectangle.
*/
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        if(r==0)return 0;
        int c = matrix[0].length;
        int[][] height = new int[r][c];
        for(int j=0;j<c;j++){
            int z = 0;
            for(int i=0;i<r;i++){
                if(matrix[i][j]=='1')z++;
                else z=0;
                height[i][j]=z;
            }
        }
         int res = 0;
        for(int i=0;i<r;i++)
            res = Math.max(res,histogram(height[i]));
        return res;
    }
    private int histogram(int[] heights) {
        int n = heights.length;
        int[] nextLower = new int[n];
        int[] prevLower = new int[n];
        Deque<Integer> ind = new ArrayDeque<>();
       for(int i=0;i<n;i++){
            while(!ind.isEmpty() && heights[ind.peek()]>=heights[i])
                ind.pop();
            prevLower[i] = ind.isEmpty() ? i+1 : i-ind.peek();
            ind.push(i);
        }
        ind = new ArrayDeque<>();
        for(int i=n-1;i>=0;i--){
            while(!ind.isEmpty() && heights[ind.peek()]>=heights[i])
                ind.pop();
            nextLower[i] = ind.isEmpty()? n-i-1 : ind.peek()-i-1; 
              ind.push(i);
        }
        int res = 0;
        for(int i=0;i<n;i++)
            res = Math.max(res ,(nextLower[i]+prevLower[i])*heights[i]);
        return res;
    }
}
