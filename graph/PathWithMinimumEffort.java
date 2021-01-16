// time complexity O(nmlog(nm))
/*  approach :
      --> use a dijkstra's algo .
      --> here distance is the absolute diff btw adjacent cells
      --> find adjacent distance of a current cell with its left,right,up,down and it to priority queue which are not visited yet
*/  
class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        pq.add(new int[]{0,0,0});
        int res = 0;
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] isVisited = new boolean[n][m];
        while(!pq.isEmpty()){
            int[] x = pq.poll();
            if(isVisited[x[0]][x[1]])continue;
            isVisited[x[0]][x[1]] = true;
            res = Math.max(res,x[2]);
            if(x[0]==n-1 && x[1]==m-1)break;
            int[] dx = {0,0,-1,1};
            int[] dy = {-1,1,0,0};
            for(int i=0;i<4;i++)
                if(isValid(x[0]+dx[i],x[1]+dy[i],n,m,isVisited))
                    pq.add(new int[]{x[0]+dx[i],x[1]+dy[i],Math.abs(heights[x[0]+dx[i]][x[1]+dy[i]]-heights[x[0]][x[1]])});
                                   
        }
        return res;
    }
    private boolean isValid(int x,int y,int n,int m,boolean[][] isVisited){
        return x>=0 && y>=0 && x<n && y<m && !isVisited[x][y];
    }
}
