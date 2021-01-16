// time O(e*v + queries.size()) , e == # of edges , v = #of vertices
/*  approach :
      --> visit vertices on topological sorting order
      --> create a 2d boolean array of size n*n where array[i][j]==true means i has a pre req of j
      --> find all prereq of a course .
      --> prereq of current course is : all prereq of its parent course + all parent course
*/
class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] allPreReq = new boolean[n][n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        int[] inDegree = new int[n];
        for(int [] ele : prerequisites){
            adj.get(ele[0]).add(ele[1]);
            inDegree[ele[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
            if(inDegree[i]==0)
                q.add(i);
        while(!q.isEmpty()){
            int x = q.poll();
            for(int neig : adj.get(x)){
                for(int i=0;i<n;i++)
                    if(allPreReq[x][i] || i==x)allPreReq[neig][i] = true;
                if(--inDegree[neig]==0)q.add(neig);
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for(int[] ele : queries){
            int prereq = ele[0];
            int course = ele[1];
            if(allPreReq[course][prereq])ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
}
