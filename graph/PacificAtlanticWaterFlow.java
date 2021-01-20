// time complexity O((nm)^2)
// appeoach : for every [i,j] , do a bfs and check if that cell is reachable to both oceans or not
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        int n = matrix.length;
        if(n==0)return res;
        int m = matrix[0].length;
        if(m==0)return res;
        boolean[][] isPossible = new boolean[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(bfs(i,j,matrix,n,m,isPossible)){
                    isPossible[i][j] = true;
                    List<Integer> point = new ArrayList<>();
                    point.add(i);point.add(j);
                    res.add(point);
                }
        return res;
    }
    private boolean bfs(int sx,int sy,int[][] matrix,int n,int m,boolean[][] isPossible){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[n][m];
        q.add(new int[]{sx,sy});
        isVisited[sx][sy] = true;
        boolean isPacific = false,isAtlantic = false;
        while(!q.isEmpty()){
            int[] z = q.poll();
            int x = z[0];int y = z[1];
            if(x==0 || y==0)isPacific = true;
            if(x==n-1 || y==m-1)isAtlantic = true;
            if((isPacific && isAtlantic) || (isPossible[x][y]))return true;
            int dx[] = {0,0,1,-1};
            int dy[] = {1,-1,0,0};
            for(int i=0;i<4;i++)
                if(isValid(x,y,x+dx[i],y+dy[i],matrix,isVisited,n,m)){
                    q.add(new int[]{x+dx[i],y+dy[i]});
                    isVisited[x+dx[i]][y+dy[i]] = true;
                }
        }
        return false;
    }
    private boolean isValid(int px,int py,int x,int y,int[][] matrix,boolean[][] isVisited,int n,int m){
        return x>=0 && y>=0 && x<n && y<m && matrix[px][py]>=matrix[x][y] && !isVisited[x][y];
    }
}
// time complexity O(nm)
/*
    approach :
      -->Two Queue and add all the Pacific border to one queue; Atlantic border to another queue.
      -->Keep a visited matrix for each queue. In the end, add the cell visited by two queue to the result.
      --> BFS: Water flood from ocean to the cell. Since water can only flow from high/equal cell to low cell, 
            add the neighboor cell with height larger or equal to current cell to the queue and mark as visited.
*/
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res =new ArrayList<>();
        int n = matrix.length; 
        if(n==0)return res;
        int m = matrix[0].length;
        if(m==0)return res;
        Queue<int[]> pacific = new LinkedList<>();
        boolean[][] pacificVisited = new boolean[n][m];
        Queue<int[]> atlantic = new LinkedList<>();
        boolean[][] atlanticVisited = new boolean[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                if(i==0 || j==0){
                    pacific.add(new int[]{i,j});
                    pacificVisited[i][j] = true;
                }
                if(i==n-1 || j==m-1){
                    atlantic.add(new int[]{i,j});
                    atlanticVisited[i][j] = true;
                }
            }
        bfs(pacific,pacificVisited,matrix,n,m);
        bfs(atlantic,atlanticVisited,matrix,n,m);
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(pacificVisited[i][j] && atlanticVisited[i][j]){
                    List<Integer> point = new ArrayList<>();
                    point.add(i);point.add(j);
                    res.add(point);
                }
        return res;
    }
    private void bfs(Queue<int[]> q,boolean[][] visited,int[][] matrix,int n,int m){
        while(!q.isEmpty()){
            int[] z = q.poll();
            int x = z[0];int y = z[1];
            int[] dx = {0,0,-1,1};
            int[] dy = {1,-1,0,0};
            for(int i=0;i<4;i++)
                if(isValid(x,y,x+dx[i],y+dy[i],matrix,n,m,visited)){
                    q.add(new int[]{x+dx[i],y+dy[i]});
                    visited[x+dx[i]][y+dy[i]] = true;
                }
        }
    }
    private boolean isValid(int px,int py,int x,int y,int[][] matrix,int n,int m,boolean[][] visited){
        return x>=0 && y>=0 && x<n && y<m && matrix[x][y]>=matrix[px][py] && !visited[x][y];
    }
}
