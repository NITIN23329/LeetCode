// time complexity  = O(# of leaf nodes(degree==1) * V) = O(V^2) 
/*  approach :
      --> from every leaf nodes , do a bfs traversal.
      --> for every vertex find maximum height , i.e. max distnce from a leaf vertex to it
      --> after finding max heights of all vertex , find vertex having minimum heights.
*/
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] degree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] ele : edges){
            adj.get(ele[0]).add(ele[1]);
            adj.get(ele[1]).add(ele[0]);
            degree[ele[0]]++;
            degree[ele[1]]++;
        }
        Queue<int[]> q = new LinkedList<>();
        int[] maxH = new int[n];
        for(int i=0;i<n;i++)
            if(degree[i]==1)q.add(new int[]{i,0,-1});   // corner/leaf nodes
        while(!q.isEmpty()){
            int[] x = q.poll();
            maxH[x[0]] = Math.max(maxH[x[0]],x[1]);
            for(int neig : adj.get(x[0]))
                if(neig!=x[2])q.add(new int[]{neig,x[1]+1,x[0]});
        }
        List<Integer> res = new ArrayList<>();
        int minH = n;
        for(int i=0;i<n;i++){
            if(maxH[i]<minH){
                minH = maxH[i];
                res = new ArrayList<>();
            }
            if(minH==maxH[i])res.add(i);
        }
           
        return res;
        
    }
}
// time complexity O(V)
/*  approach: 
        1) do a topological bfs
        2) initially add all nodes having degree==1 to q
        3) poll from q and reduce degree of its adjancent and add all adjacent nodes having degree==1 to q
        4) the order in which bfs is done give the height of each node
        5) leaf nodes has height 0 , all neighbour node of leaf node having degree ==1 after step 2 have heights 2 and so on..
        6) as a matter of fact, we can have atmost 2 root nodes as our result out of given graph. see :https://leetcode.com/problems/minimum-height-trees/solution/
*/
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] degree = new int[n];  //stores degree of each node
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] ele : edges){
            adj.get(ele[0]).add(ele[1]);
            adj.get(ele[1]).add(ele[0]);
            degree[ele[0]]++;
            degree[ele[1]]++;
        }
        Queue<int[]> q = new LinkedList<>();
        int[] height = new int[n];   // stores height of tree having index node as root
        int maxH = 0;           // the maximum height of tree 
        for(int i=0;i<n;i++)
            if(degree[i]==1)q.add(new int[]{i,0});   // corner/leaf nodes
        while(!q.isEmpty()){
            int[] x = q.poll();
            height[x[0]] = x[1];
            maxH = Math.max(maxH,x[1]);
            for(int neig : adj.get(x[0]))
                if(--degree[neig]==1)q.add(new int[]{neig,x[1]+1});
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++)
            if(maxH==height[i])res.add(i);
        return res;
    }
}
