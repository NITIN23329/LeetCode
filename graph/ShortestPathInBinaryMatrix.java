// time O(n^2)
// do a bfs
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        boolean[][] isVisited = new boolean[n][n];
        if(grid[0][0]==1)return -1;
        q.add(new int[]{0,0,1});
        isVisited[0][0] = true;
        while(!q.isEmpty()){
            int[] z = q.poll();
            int x = z[0];int y= z[1];
            if(x==n-1 && y==n-1)return z[2];
            int[] dx = {1,1,1,0,0,-1,-1,-1};
            int[] dy = {0,1,-1,1,-1,0,1,-1};
            for(int i=0;i<8;i++)
                if(isValid(x+dx[i],y+dy[i],grid,isVisited,n)){
                    q.add(new int[]{x+dx[i],y+dy[i],z[2]+1});
                    isVisited[x+dx[i]][y+dy[i]] = true;
                }
        }
        return -1;
    }
    private boolean isValid(int x,int y,int[][] grid,boolean[][] isVisited,int n){
        return x>=0 && y>=0 && x<n && y<n && grid[x][y]==0 && !isVisited[x][y];
    }
}
