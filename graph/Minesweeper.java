// time O(nm)
/*  approach :
      --> if click is a 'M' convert it to 'X'
      --> else do a bfs starting from click.
             --> for every cell , count adjacent mines. 
                   -->if adjacent mines!=0 , cell value = adjacent mines
                   --> cell valie = 'B' and add  all adjacent 'E'(unreaveled cells) to queue.
*/
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        Queue<int[]> q = new LinkedList<>();
        if(board[click[0]][click[1]]=='M')board[click[0]][click[1]]='X';
        else q.add(click);
        int n = board.length;int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        visited[click[0]][click[1]] = true;
        while(!q.isEmpty()){
            int[] z = q.poll();
            int x = z[0];int y = z[1];
            int[] dx = {1,1,1,-1,-1,-1,0,0};
            int[] dy = {-1,0,1,-1,0,1,-1,1};
            int adjMine = 0;
            for(int i=0;i<8;i++)
                if(isValid(x+dx[i],y+dy[i],n,m,board,'M'))adjMine++;
            if(adjMine==0){
                board[x][y] ='B';
                for(int i=0;i<8;i++)
                    if(isValid(x+dx[i],y+dy[i],n,m,board,'E') && !visited[x+dx[i]][y+dy[i]]){
                            q.add(new int[]{x+dx[i],y+dy[i]});
                            visited[x+dx[i]][y+dy[i]] = true;
                    }  
            }
            else board[x][y] = (char)(adjMine+'0');
        }
        return board;
    }
    private boolean isValid(int x ,int y,int n,int m,char[][]board,char c){
        return x>=0 && y>=0 && x<n && y<m &&(board[x][y]==c);
    }
}
