//time complexity O(e+v) if we ignore sorting time 
/*  approach : do a inverse topological sorting
      -->a node is eventually safe if all it's outgoing edges are to nodes that are eventually safe.
      -->we start with nodes that have no outgoing edges - those are eventually safe. 
      -->Now, we can update any nodes which only point to eventually safe nodes - those are also eventually safe. Then, we can update again, and so on.
      --> in reverse of topo soring, store out-degree of each vertex
      --> for a safe node , remove it's indegree edges and add those neighbours whose indegree is 0

*/
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] outDegree = new int[n];
        Map<Integer,List<Integer>> inEdge = new HashMap<>();
        for(int i=0;i<n;i++)inEdge.put(i,new ArrayList<>());
        for(int x=0;x<n;x++){
            for(int y : graph[x]){
                outDegree[x]++;
                inEdge.get(y).add(x);
            }
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
            if(outDegree[i]==0)q.add(i);
        while(!q.isEmpty()){
            int x = q.poll();
            res.add(x);
            for(int in : inEdge.get(x))
                if(--outDegree[in]==0)q.add(in);   
        }
        Collections.sort(res);
        return res;
        
    }
}

