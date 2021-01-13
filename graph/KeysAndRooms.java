// time O(v+e)
// do a bfs
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> isVisited = new HashSet<>();
        q.add(0);
        isVisited.add(0);
        while(!q.isEmpty()){
            int key = q.poll();
            List<Integer> neig = rooms.get(key);
            for(int ele : neig){
                if(!isVisited.contains(ele)){
                    q.add(ele);
                    isVisited.add(ele);
                }
            }
        }
        return isVisited.size()==rooms.size();
    }
}
