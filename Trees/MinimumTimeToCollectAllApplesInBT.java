
//time O(n) , space O(height)
/*  approach :
      -->the first thing comes in mind is to do a dfs
      --> In dfs, we will visit a node only if the subtree starting from that node has some apples.
      --> if a subtree starting from a node has apple, then we are gonna come from parent node to the that node and go back to parent node. Hence add 2 to answer.
      --> Node the root node dont need to add a 2 cuz its the starting node .
*/
class Solution {
    int ans = 0;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<Integer>[] tree = new ArrayList[n];
        for(int i=0;i<n;i++)tree[i] = new ArrayList<>();
        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            tree[x].add(y);
            tree[y].add(x);
        }
        dfs(0,-1,hasApple,tree);
        return ans;
    }
    private boolean dfs(int curr,int parent,List<Boolean> hasApple,ArrayList<Integer>[] tree){
        boolean hasAppleInSubtree = hasApple.get(curr);     // check if current node has apple or not.
        for(int neig : tree[curr]){
            if(neig == parent)continue;
            hasAppleInSubtree |= dfs(neig,curr,hasApple,tree);    // check if any subtree of current node has apple or not
        }
        if(hasAppleInSubtree && curr!=0)  // if any subtree starting from current node have some apples, then we are gonna come to  the current node and go back
            ans+=2;     // so add 2 .
        return hasAppleInSubtree;   // indicate we wanna also visit its parent if true.
    }
}
