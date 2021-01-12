//time O(nm) , spaceO(nm)
// approach : do a bfs
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(grid[i][j]==2)
                    q.add(new int[]{i,j,0});
        int time = 0;
        while(!q.isEmpty()){
            int[] x = q.poll();
            time = Math.max(time,x[2]);
            int i = x[0];
            int j = x[1];
            if(isValid(grid,i-1,j,n,m)){
                grid[i-1][j]=2;
                q.add(new int[]{i-1,j,time+1});
            }
            if(isValid(grid,i+1,j,n,m)){
                grid[i+1][j]=2;
                q.add(new int[]{i+1,j,time+1});
            }
            if(isValid(grid,i,j-1,n,m)){
                grid[i][j-1]=2;
                q.add(new int[]{i,j-1,time+1});
            }
            if(isValid(grid,i,j+1,n,m)){
                grid[i][j+1]=2;
                q.add(new int[]{i,j+1,time+1});
            }
        }
         for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(grid[i][j]==1)
                    return -1;
        return time;
    }
    private boolean isValid(int[][] arr,int x,int y,int n,int m){
        return x>=0 && y>=0 && x<n && y<m && arr[x][y]==1;
    } 
}
