//time O(n^2) space O(edges+vertices)
/*  approach 
        --> form a adjacency list out of given edges
        --> only by one remove edges and do dfs to check if all nodes are visited after removal of an edge
        --> if yes then this connection is redundant
*/
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<edges.length;i++)adjList.add(new ArrayList<>());
        for(int[] ele : edges){
            adjList.get(ele[0]-1).add(ele[1]-1);
            adjList.get(ele[1]-1).add(ele[0]-1);
        }
        for(int i=edges.length-1;i>=0;i--){
            Set<Integer> visited = new HashSet<>();
            dfs(adjList,visited,0,edges[i]);
            if(visited.size()==edges.length)return edges[i];
        }
        return null;
    }
    private void dfs( List<List<Integer>> adjList,Set<Integer> set,int parent,
                    int[] exclude){
        set.add(parent);
        for(int ele: adjList.get(parent)){
            if(!set.contains(ele)){
                if((parent==exclude[0]-1 && ele==exclude[1]-1)|| 
                   (parent==exclude[1]-1 && ele==exclude[0]-1));
                else dfs(adjList,set,ele,exclude);
            }
        }
    }
}
