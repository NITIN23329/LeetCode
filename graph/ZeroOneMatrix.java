// time complexity O(nm)
// do a bfs
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(matrix[i][j]==0){
                   q.add(new int[]{i,j,0});
                    visited[i][j] = true;
                }
        int[][] distance = new int[n][m];
        while(!q.isEmpty()){
            int[] z = q.poll();
            int x = z[0];int y = z[1];int d = z[2];
            distance[x][y] = d;
            int[] dx ={0,0,-1,1};
            int[] dy = {1,-1,0,0};
            for(int i=0;i<4;i++)
                if(isValid(x+dx[i],y+dy[i],n,m,matrix,visited)){
                    q.add(new int[]{x+dx[i],y+dy[i],d+1});
                    visited[x+dx[i]][y+dy[i]] = true;
                }
        }
        return distance;
    }
    private boolean isValid(int x,int y,int n,int m,int[][] matrix,boolean[][] visited){
        return x>=0 && y>=0 && x<n && y<m && matrix[x][y]==1 && !visited[x][y];
    }
}
