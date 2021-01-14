//time complexity O(e+v)
/*  approach : do a bfs
      -->color neighbour vertices of red vertix with green and color neighbour vertices of green vertix with red.
      --> if 2 adjucent vertices got same color , then this is not a bipartite graph
*/
class Solution {
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int x=0;x<n;x++){
            for(int  y : graph[x]){
                adj.get(x).add(y);
                adj.get(y).add(x);
            }
        }
        
        boolean [] isVisited = new boolean[n];
        boolean [] color = new boolean[n];
        for(int i=0;i<n;i++)
            if(!isVisited[i])
                if(!bfs(adj,i,isVisited,color))return false;
        return true;
    }
    private boolean bfs( List<List<Integer>> adj,int curr,boolean [] isVisited,boolean [] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        isVisited[curr] = true;
        color[curr] = true;
        while(!q.isEmpty()){
            int x = q.poll();
            for(int neig : adj.get(x)){
                if(!isVisited[neig]){
                    q.add(neig);
                    isVisited[neig] = true;
                    color[neig] = !color[x];
                }
                else if(color[neig]==color[x])return false;
            }
        }
        return true;
    }
}
