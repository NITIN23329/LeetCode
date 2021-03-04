// time complexity for constructor in O(nm) , time complexiyt of sumRegion() is O(1)
/*
    approach : do a pictorial representation and find the approach, it would be easier to understand
        --> just like in case of 1d array , we will store prefix sum for every cell.
        --> prefix[i][j] denotes the sum of all elements of a matrix ending at cell prefix[i][j].
        -->  prefix[r][c] = matrix[r][c] + prefix[r][c-1] + prefix[r-1][c] - prefix[r-1][c-1]; , what does it means ?
        --> it means to get sum of elements of a matrix ending at cell{r,c}  = matrix[r][c] + matrix sum ending at cell{r-1,c} + matrix sum ending at cell{r,c-1} - matrix sum ending at cell{r-1,c-1}
*/
class NumMatrix {
    int[][] prefix ;
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        if(row==0){
            prefix = new int[][]{{0}};
            return;
        }
        int col = matrix[0].length;
        prefix = new int[row][col];
        prefix[0][0] = matrix[0][0];
        for(int c = 1;c<col;c++)
            prefix[0][c] = prefix[0][c-1] + matrix[0][c];
        for(int r = 1;r<row;r++)
            prefix[r][0] = prefix[r-1][0] + matrix[r][0];
        for(int r=1;r<row;r++)
            for(int c =1;c<col;c++)
                prefix[r][c] = matrix[r][c] + prefix[r][c-1] + prefix[r-1][c] - prefix[r-1][c-1];
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
       return prefix[row2][col2] - (col1-1>=0?prefix[row2][col1-1]:0) - 
           (row1-1>=0?prefix[row1-1][col2]:0) + (row1-1>=0 && col1-1>=0? prefix[row1-1][col1-1]:0);
    }
}
