// time complexity O(n^2) , space complexity o(n^2)
/*  approach :
      --> find 1st island , do a dfs and find all cells which are adjacent to water(0)
      --> from these cell, do a bfs and search for 2nd island.
*/
class Solution {
    public int shortestBridge(int[][] arr) {
        int n = arr.length;
        boolean[][] isVisited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        boolean isFirstIsland = false;
        for(int i=0;i<n;i++){
             for(int j=0;j<n;j++)
                if(arr[i][j]==1){
                    dfs(arr,i,j,n,isVisited,q);
                    isFirstIsland = true;
                    break;
                }
            if(isFirstIsland)break;
        }
           
        return bfs(arr,n,q,isVisited);
    }
    private void dfs(int[][] arr,int x,int y,int n,boolean[][] isVisited,Queue<int[]> q){
        int[] dx = {0,0,1,-1};
        int[] dy = {-1,1,0,0};
        boolean isCornerOne = false;
                
        for(int i=0;i<4;i++)
            if(isValid(x+dx[i],y+dy[i],n,isVisited,arr,0)){
                isCornerOne = true;
                break;
            }
        if(isCornerOne)q.add(new int[]{x,y});
        isVisited[x][y] = true;

        for(int i=0;i<4;i++)
            if(isValid(x+dx[i],y+dy[i],n,isVisited,arr,1)){
                 dfs(arr,x+dx[i],y+dy[i],n,isVisited,q);
            }   
    }
    private boolean isValid(int x,int y,int n,boolean[][] isVisited,int[][] arr,int v){
        return x>=0 && y>=0 && x<n && y<n && arr[x][y]==v && !isVisited[x][y];
    }
    private int bfs(int[][] arr,int n,Queue<int[]> q,boolean[][] isVisited){
        int c = 0;
        while(!q.isEmpty()){
            int s = q.size();
            for(int ii=0;ii<s;ii++){
                int[] z = q.poll();
                int x = z[0];int y = z[1];
                int[] dx = {0,0,1,-1};
                int[] dy = {-1,1,0,0};
                for(int i=0;i<4;i++){
                    if(isValid(x+dx[i],y+dy[i],n,isVisited,arr,0)){
                         q.add(new int[]{x+dx[i],y+dy[i]});
                        isVisited[x+dx[i]][y+dy[i]] = true;
                    }
                    else if(isValid(x+dx[i],y+dy[i],n,isVisited,arr,1))
                        return c;
                }
            }
            c++;      
        }
        return -1;
    }
}
