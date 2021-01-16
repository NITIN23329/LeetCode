// time O(e+v) , space O(v)
// simply do topological sorting and check is all vertices are visited or not
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());
        int[] inDegree = new int[numCourses];
        for(int[] ele : prerequisites){
            adj.get(ele[0]).add(ele[1]);
            inDegree[ele[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
            if(inDegree[i]==0)q.add(i);
        int topo = 0;
        while(!q.isEmpty()){
            int x = q.poll();
            topo++;
            for(int neig : adj.get(x)){
                if(--inDegree[neig]==0)
                    q.add(neig);
            }
        }
        return topo==numCourses;
    }
}
