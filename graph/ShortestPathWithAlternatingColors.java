// time complexity O(e+v) , space complexity O(
/*  approach :
      --> along with neighbour vertices, we store the color of edge in adj list. if color is red, we store 0 else 1.
      -->traverse through every edge using a bfs.
      --> bfs ensures the shortest path from i to j vertices if any
      --> instead of visitedNode, we used visitedEdge cuz there may be self loops with different color.
      --> these self loops are indeed helpful, consider red_edge = [[0,1],[1,2]] , blue_edge = [1,1].
      --> visitedEdge ensure we do not travese an edge multiple times
*/
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[] distance = new int[n];
        Arrays.fill(distance,-1);
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] ele : red_edges)
            adj.get(ele[0]).add(new int[]{ele[1],0});
        for(int [] ele : blue_edges)
            adj.get(ele[0]).add(new int[]{ele[1],1});
        bfs(adj,distance,0,n);
        return distance;
    }
    private void bfs(List<List<int[]>> adj,int[]distance,int curr,int n){
        Queue<int[]> q = new LinkedList<>();
        // if there is a edge from i to j with color red, then visitedEdge[i][j][0]=true
        // if there is a edge from i to j with color blue, then visitedEdge[i][j][1]=true
        boolean[][][] visitedEdge = new boolean[n][n][2];
        q.add(new int[]{curr,0,-1});
        while(!q.isEmpty()){
            int[] x = q.poll();
            if(distance[x[0]]==-1)distance[x[0]] = x[1];
            int newColor = x[2]==0? 1 : 0;
            for(int[] neig : adj.get(x[0]))
                if((neig[1]==newColor || x[0]==0) && !visitedEdge[x[0]][neig[0]][neig[1]]){
                    q.add(new int[]{neig[0],x[1]+1,neig[1]});
                    visitedEdge[x[0]][neig[0]][neig[1]]=true;
                }
                    
        }
        
    }
}
