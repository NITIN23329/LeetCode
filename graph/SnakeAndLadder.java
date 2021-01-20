// time O(n^2)
/*  approach :
        --> do a bfs
        --> on every move consider all 6 moves
        --> keep a track to visited cells to remove infinte loop
*/
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n*n+1];
        int c = 0;int idx=1;
        for(int i=n-1;i>=0;i--){
            if(c%2==0){
                for(int j=0;j<n;j++)
                    arr[idx++] = board[i][j];
            }else{
                for(int j=n-1;j>=0;j--)
                    arr[idx++] = board[i][j];
            }
            c++;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,0});
        boolean[] isVisited = new boolean[n*n+1];
        isVisited[1] = true;
        while(!q.isEmpty()){
            int[] x = q.poll();
            if(x[0]==n*n)return x[1];
            for(int i=1;i<=6;i++)
            if(x[0]+i<=n*n && !isVisited[x[0]+i]){
                q.add(new int[]{arr[x[0]+i]==-1 ? x[0]+i : arr[x[0]+i],x[1]+1});
                isVisited[x[0]+i] = true;
            } 
               
        }
        return -1;
        
    }
}
