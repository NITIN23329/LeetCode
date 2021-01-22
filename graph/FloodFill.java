// time complexity O(nm)
// do a dfs , use visited array cuz newColor may be same as oldColor
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;int m = image[0].length;
        dfs(image,sr,sc,newColor,image[sr][sc],n,m,new boolean[n][m]);
        return image;
    }
    private void dfs(int[][] image,int x,int y,int nc,int sc,int n, int m,boolean[][] isVisited){
        image[x][y] = nc;
        isVisited[x][y] = true;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};
        for(int i=0;i<4;i++)
            if(isValid(x+dx[i],y+dy[i],image,sc,n,m,isVisited))
                dfs(image,x+dx[i],y+dy[i],nc,sc,n,m,isVisited);
    }
    private boolean isValid(int x,int y,int[][] image, int pc,int n,int m,boolean[][] isVisited){
        return x>=0 && y>=0 && x<n && y<m && image[x][y]==pc && !isVisited[x][y];
    }
}
