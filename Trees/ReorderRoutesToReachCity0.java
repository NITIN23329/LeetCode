//time O(N) 
/*
approach :
     --> out of given connections form a undirected graph to eleminate disjoint subgraphs
     --> store all connections in a map
     --> do bfs starting from node 0
     -->if the path from child to parent is not present in map , increment our counter
*/
class Solution {
    int c;
    public int minReorder(int n, int[][] connections) {
      List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());
        Map<Integer,Integer[]> map = new HashMap<>();
        for(int[] ele : connections){
            int f = ele[0];
            int t = ele[1];
            if(!map.containsKey(f))map.put(f,new Integer[]{-1,-1});
            if(map.get(f)[0]==-1)map.get(f)[0]=t;
            else map.get(f)[1]=t;
            adjList.get(f).add(t);
            adjList.get(t).add(f);
        }
        bfs(adjList,n,map);
        return c;
    }
    private void bfs(List<List<Integer>> adj,int n,Map<Integer,Integer[]> map){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(0);
        while(!q.isEmpty()){
            int parent = q.poll();
            visited[parent]=true;
            for(int child : adj.get(parent)){
                if(!visited[child]){
                    Integer[] reach=map.get(child);
                    if(reach==null || (reach[0]!=parent && reach[1]!=parent))c++;
                     q.add(child);
                }
                
            }
        }
    }
}
