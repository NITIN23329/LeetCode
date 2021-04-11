// problem link : https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
// time and space complexity : O(n)
// adjacent elements are like neighbours, there is an edge btw them. So create an adjacency list of neighbours.
// start dfs from a element having onnly one neighbour and visit all nodes that are not visited yet and add them in an array untill all nodes are visited.
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int inf = Integer.MAX_VALUE;
        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int[] ele : adjacentPairs){
            int x = ele[0],y = ele[1];
            if(!adj.containsKey(x))adj.put(x,new ArrayList<>());
            if(!adj.containsKey(y))adj.put(y,new ArrayList<>());
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        int start = 0;
        for(int key:adj.keySet())
            if(adj.get(key).size()==1){
                start = key;
                break;
            }
        int[] ans = new int[adjacentPairs.length+1];
        dfs(start,ans,new HashSet<>(),0,adj);
        return ans;
    }
    private void dfs(int curr,int[] ans,Set<Integer> isAdded,int i,Map<Integer,List<Integer>> adj ){
        ans[i] = curr;
        isAdded.add(curr);
        for(int adjacent : adj.get(curr))
            if(!isAdded.contains(adjacent))
                dfs(adjacent,ans,isAdded,i+1,adj);
    }
}
