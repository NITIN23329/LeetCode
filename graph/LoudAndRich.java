// time complexity : O(e+v)
/*  approach : using topological traversal
      --> we know that no node is richer than the leaf nodes(or nodes having indegree==0) , so ans for those nodes is node themself
      --> do a topological traversal , which ensures we visit node more richer nodes first 
      --> if we find that the quitness level of its parent is < quitness level of neighbour node , 
              we update the quitness level of neighbour node and the ans for neighbour node is = ans of parent node.
*/
class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = quiet.length;
        int[] inDegree = new int[n];
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int [] ele : richer){
            inDegree[ele[1]]++;
            adj.get(ele[0]).add(ele[1]);
        }
        int[] res = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
             res[i] = i;
            if(inDegree[i]==0)
                q.add(i);
        }
        while(!q.isEmpty()){
            int x = q.poll();
            for(int neig : adj.get(x)){
                if(--inDegree[neig]==0)q.add(neig);
                if(quiet[neig]>quiet[res[x]]){
                    res[neig] = res[x];
                    quiet[neig] = quiet[res[x]];
                }
            }
        }
        return res;
    }
}
