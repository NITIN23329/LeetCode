// time O(nlogn)
/*  approach :
        --> do a bfs , find all friends at a distance of k from given id.
        --> find all movies seen by these friends
        --> sort them according to given conditions
*/
class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = watchedVideos.size();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int x=0;x<n;x++)
            for(int y: friends[x]){
                adj.get(x).add(y);
                adj.get(y).add(x);
            }
        Map<String,Pair> freq = new HashMap<>();
        bfs(adj,id,level,freq,watchedVideos);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.freq != b.freq? a.freq-b.freq: a.str.compareTo(b.str)));
        for(String movie : freq.keySet())
            pq.add(freq.get(movie));
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty())res.add(pq.poll().str);
        return res;
    }
    private void bfs(List<List<Integer>> adj,int start,int k,Map<String,Pair> freq, List<List<String>> watchedVideos){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        q.add(start);
        visited[start] = true;
        for(int i=0;i<k;i++){
            int s = q.size();
            for(int j=0;j<s;j++){
                int parent = q.poll();
                for(int neig : adj.get(parent)){
                    if(!visited[neig]){
                        q.add(neig);
                        visited[neig] = true;
                    }
                }
            }
            
        }
        while(!q.isEmpty()){
            for(String movie : watchedVideos.get(q.poll())){
                    if(!freq.containsKey(movie))freq.put(movie,new Pair(movie,0));
                    freq.get(movie).freq+=1;
            }
        }
    }
    
}
class Pair{
    String str;
    int freq;
    public Pair(String s,int val){
        str=s;
        freq =val;
    }
}
