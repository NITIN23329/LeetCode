// time complexity O(nm)
/*  approach :
      --> alternative way is that we can not convert those 'O' to 'X' which are connected to boundary 'O's.
      --> find all 'O's which are connected to boundary 'O's and rest will be converted to 'X'
*/
class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        if(n==0)return;
        int m = board[0].length;
        if(m==0)return;
        boolean[][] isVisited = new boolean[n][m];
        for(int col=0;col<m;col++){
            if(board[0][col]=='O' && !isVisited[0][col])
                bfs(0,col,isVisited,board);
            if(board[n-1][col]=='O' && !isVisited[n-1][col])
                bfs(n-1,col,isVisited,board);
        }
        for(int row=0;row<n;row++){
            if(board[row][0]=='O' && !isVisited[row][0])
                bfs(row,0,isVisited,board);
            if(board[row][m-1]=='O' && !isVisited[row][m-1])
                bfs(row,m-1,isVisited,board);
        }
        for(int row=0;row<n;row++)
            for(int col=0;col<m;col++)
                if(board[row][col]=='O' && !isVisited[row][col])
                    board[row][col]='X';  
    }
    private void bfs(int a,int b,boolean[][] isVisited,char[][] board){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a,b});
        isVisited[a][b] = true;
        while(!q.isEmpty()){
            int[] z = q.poll();
            int x = z[0];int y = z[1];
            int[] dx = {0,0,-1,1};
            int[] dy = {1,-1,0,0};
            for(int i=0;i<4;i++){
                if(isValid(x+dx[i],y+dy[i],board,isVisited)){
                    q.add(new int[]{x+dx[i],y+dy[i]});
                    isVisited[x+dx[i]][y+dy[i]] = true;
                }
            }
        }
    }
    private boolean isValid(int x,int y,char[][] board,boolean[][] isVisited){
        return x>=0 && y>=0 && x<board.length && y<board[0].length && 
            board[x][y]=='O'&& !isVisited[x][y];
    }
}
