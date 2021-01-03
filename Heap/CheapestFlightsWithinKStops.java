/*
  approach 1 : doing dfs[TLE]
      --> do dfs to amost k distant node
      --> find all paths from src to dst and find least weighted path
*/
class Solution {
    int res;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Integer[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int [] ele : flights)
            adj.get(ele[0]).add(new Integer[]{ele[1],ele[2]});
        res=Integer.MAX_VALUE;
        dfs(adj,src,dst,k,new HashSet<>(),0,0);
        return res==Integer.MAX_VALUE? -1 : res;
    }
    private void dfs(ArrayList<ArrayList<Integer[]>> adj,int parent,int dst,int k,  Set<Integer> visited,int currK,int currD){
        if(visited.contains(parent) || currK>k+1)return;
        visited.add(parent);
        if(parent==dst)res = Math.min(res,currD);
        for(Integer[] neig : adj.get(parent)){
            dfs(adj,neig[0],dst,k,visited,currK+1,currD+neig[1]);
        }
        visited.remove(parent);
    }
}
/*
  approach 2 : dijkstra's algo
  --> we have a min heap which has node index , edge weight and distance from src as int[].
  --> add all nodes in priority queue which are atmost distant of k .
  --> as soon as we find our destination , we return the cost as the min heap will ensure it is themost  minimum cost path from src to dst.
  --> we do not need to track the visited nodes as if there was cycle, 
  -->it will add to cost more and more on looping over that cycle untill its cost become significantly high or we exhaust all k steps
*/
 /*                                        
                                      0
                                   /    /\
                               10 /      \
                                 /        \  10                       
                                \/.        \
                                 1 -------> 2----------->3
                                      10.         1000
*/
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Integer[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int [] ele : flights)
            adj.get(ele[0]).add(new Integer[]{ele[1],ele[2]});
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        pq.add(new int[]{src,0,0});
        int distance[] = new int[n];
        while(!pq.isEmpty()){
            int[] parent = pq.poll();
            distance[parent[0]] = parent[1];
            if(parent[0]==dst)return parent[1];
            for(Integer[] neig : adj.get(parent[0]))
                if(parent[2]+1<=k+1){
                pq.add(new int[]{neig[0],distance[parent[0]]+neig[1],parent[2]+1});
                }  
        }
        return -1;
        
    }
}

