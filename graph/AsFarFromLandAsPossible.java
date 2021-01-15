//time complexity O(n*n)
//approach : do a bfs and find maximum distance from 1
class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        boolean[][] isVisited = new boolean[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j]==1){
                    q.add(new int[]{i,j,0});
                    isVisited[i][j] = true;
                }
        if(q.isEmpty() || q.size()==n*n)return -1;
        int maxD = 0;
        while(!q.isEmpty()){
            int[] z = q.poll();
            maxD = Math.max(maxD,z[2]);
            int[] dx = {0,0,-1,1};
            int[] dy = {1,-1,0,0};
            for(int i=0;i<4;i++)
                if(isValid(z[0]+dx[i],z[1]+dy[i],n,isVisited)){
                    q.add(new int[]{z[0]+dx[i],z[1]+dy[i],z[2]+1});
                    isVisited[z[0]+dx[i]][z[1]+dy[i]] = true;
                }
        }
        return maxD;
    }
    private boolean isValid(int x, int y,int n,boolean[][] isVisited){
        return x>=0 && y>=0 && x<n && y<n && !isVisited[x][y];
    }
}
