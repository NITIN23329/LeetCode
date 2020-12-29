
//time O(n) , space O(height)
/*  approach :
      -->the first thing comes in mind is to do a dfs
      --> in dfs we need to return 2 things , answer of current node and whether current nodes sees in apple down or not.
      --> starting from a current node how we will calculate time ?
      --> find sum of time of all childeren , 
      -->if any childeren got apple or current node has apple, we will add 2 to our result to find time for current node's parent.
      -->one corner case is that for the root node , we will add 2 extra which needed to be removed from our answer,if there is any apple present in tree
*/
class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] ele : edges){
            int x = ele[0];int y = ele[1];
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        int[] res = dfs(adj,0,hasApple,new boolean[n]);
        if(res[1]==1)res[0]-=2;
        return res[0];
    }
    private int[] dfs(List<List<Integer>> adj,int curr,List<Boolean> hasApple,boolean[] visited){
        if(visited[curr])return new int[]{0,0};
        visited[curr] = true;
        int[]  res= new int[]{0,0};
        for(int neig: adj.get(curr)){
            int[] x = dfs(adj,neig,hasApple,visited);
            res[0]+=x[0];if(x[1]==1)res[1]=1;
        }
        if(hasApple.get(curr) || res[1]==1){
            res[0]+=2;res[1]=1;
        }
        return res;
    }
}
