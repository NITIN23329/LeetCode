//time O(e+v) , space O(v)
// do topo sorting
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());
        int[] inDegree = new int[numCourses];
        for(int[] ele : prerequisites){
            adj.get(ele[1]).add(ele[0]);
            inDegree[ele[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
            if(inDegree[i]==0)q.add(i);
        int[] topo = new int[numCourses];
        int idx = 0;
        while(!q.isEmpty()){
            int x = q.poll();
            topo[idx++]=x;
            for(int neig : adj.get(x)){
                if(--inDegree[neig]==0)
                    q.add(neig);
            }
        }
        return idx==numCourses ? topo : new int[0];
    }
}
