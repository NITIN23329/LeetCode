// time complexity O(n)
/*  approach :    
        --> form a tree in form of adj list. Here tree is a directed graph having weights.
        --> start from the headID do a dfs/bfs/topological traversal and find time needed to reach each node
        --> find maximum time .
*/
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            if(manager[i]==-1)continue;
            adj.get(manager[i]).add(new int[]{i,informTime[manager[i]]});
        }
        return dfs(adj,headID,0);
    }
    private int dfs(List<List<int[]>> adj,int root, int time){
        int max = time;
        for(int[] neig : adj.get(root))
            max = Math.max(max,dfs(adj,neig[0],time+neig[1]));
        return max;
    }
}
