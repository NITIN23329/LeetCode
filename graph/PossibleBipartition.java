// time complexity O(e+v) , space complexity O(v)
//disclamer : a detect cycle in undirected graph won't work . consider [[1,3],[1,2],[2,4],[3,4]]
/*  apporach : same a graph bipartier solution
      --> for a graph in which each dislike vertices have direct edge to each other
      --> try coloring alternatively to consecutive vertices
      --> if 2 adjacent vertices have same color, it means they both dislike each other and are in same group, return false
      --> if each adjacent vertices are of differnt color , return true
      --> we can either use bfs as we did in isGraphBipartite.java :https://github.com/NITIN23329/LeetCode/blob/2c69ba154f380281835f8bf89522a2cb9ba37561/graph/IsGraphBipartite.java#L1
      --> or we can do a dfs as i did in below solution
*/
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        boolean[] set1 = new boolean[N+1];
        boolean[] set2 = new boolean[N+1];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=N;i++)adj.add(new ArrayList<>());
        for(int[] ele : dislikes){
            adj.get(ele[0]).add(ele[1]);
            adj.get(ele[1]).add(ele[0]);
        }
        for(int i=1;i<=N;i++)
            if(!set1[i] && !set2[i])
                if(!dfs(adj,set1,set2,i,true))return false;
        return true;
    }
    private boolean dfs( List<List<Integer>> adj, boolean[] set1, boolean[] set2,int curr,boolean isSet1){
        if(isSet1)set1[curr] = true;
        else set2[curr] = true;
        for(int neig : adj.get(curr)){
            if(!set1[neig] && !set2[neig])
                dfs(adj,set1,set2,neig,!isSet1);
            else if((set1[neig] && set1[curr]) || (set2[neig] && set2[curr]))
                return false;
        }
        return true;
        
    }
}
