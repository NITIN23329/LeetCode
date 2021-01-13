// time O(V+E)
// for a town judge , as he trust nobody so its outdegree is 0.
// for a town judge, as everybody other trust , its indegree == N-1
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] inDegree = new int[N+1];
        int[] outDegree = new int[N+1];
        for(int[] conn : trust){
            int x = conn[0];
            int y = conn[1];
            outDegree[x]++;
            inDegree[y]++;
        }
        for(int i=1;i<N+1;i++){
            if(inDegree[i]==N-1 && outDegree[i]==0)
                return i;
        }
        return -1;
    }
}
