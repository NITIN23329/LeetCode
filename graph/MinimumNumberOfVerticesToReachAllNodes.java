// time complexity O(e+v) , space complexity O(e+v)
/*  approach : using dfs
      --> like kosa raju algo , store a stack in decreasing order of visit time of vertices
      --> after visiting every neighbour node , push it to stack
      --> element at top is completed at last.
      --> pop a not visited element from stack , and do dfs 
      --> add the poped item to result
*/
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] isVisited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(List<Integer> ele : edges)adj.get(ele.get(0)).add(ele.get(1));
        for(int i=0;i<n;i++)
            if(!isVisited[i])dfs(adj,i,isVisited,dq);
        List<Integer> res = new ArrayList<>();
        isVisited = new boolean[n];
        while(!dq.isEmpty()){
            int x = dq.poll();
            if(isVisited[x])continue;
            dfs(adj,x,isVisited,new ArrayDeque<>());
            res.add(x);
        }
        return res;
        
    }
    private void dfs(List<List<Integer>> adj, int curr, boolean[] isVisited, Deque<Integer> dq){
        if(isVisited[curr])return;
        isVisited[curr] =true;
        for(int neig : adj.get(curr))
            if(!isVisited[neig])
                dfs(adj,neig,isVisited,dq);
        dq.push(curr);
    }
    
}
// time complexity O(e+v) , space complexity O(v)
/*  approach :
        --> store the indegree of each node
        --> those nodes having indegree==0 , we can not reach to them so add it to result
      
*/
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
       int[] inDegree = new int[n];
        for(List<Integer> ele : edges)inDegree[ele.get(1)]++;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++)
            if(inDegree[i]==0)res.add(i);
        return res;
    }
    
}
