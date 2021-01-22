// time complexity O(nm)
// do a dfs as and when you find a cell value 1,
//check if we can reach boundary or not, if not add the # of cells having 1 during the dfs to answer.
class Solution {
    boolean isEdgeReachable;
    public int numEnclaves(int[][] A) {
        int res=0;
        int n = A.length;int m = A[0].length;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(A[i][j]==1){
                    isEdgeReachable=false;
                    int c = dfs(i,j,A,n,m);
                    if(!isEdgeReachable)res+=c;
                }
        return res;
    }
    private int dfs(int x,int y,int[][]A,int n, int m){
        A[x][y] = 0;
        int c = 1;
        if(x==0 || y==0 || x==n-1 || y==m-1)isEdgeReachable = true;
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        for(int i=0;i<4;i++)
            if(isValid(x+dx[i],y+dy[i],A,n,m))
                c+=dfs(x+dx[i],y+dy[i],A,n,m);
        return c;
    }
    private boolean isValid(int x,int y,int[][] A,int n,int m){
        return x>=0 && y>=0 && x<n && y<m && A[x][y]==1;
    }
}     
