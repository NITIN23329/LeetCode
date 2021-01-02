//time complexity : O(VlogE) = O(nlog(times.length)) , space complexity : O(E) =  O(times.length)
//apply dijkstras algorithm
class Solution {
    ArrayList<ArrayList<Integer[]>> adj;
    Set<Integer> visited;
    PriorityQueue<Integer[]> pq;
    public int networkDelayTime(int[][] times, int n, int k) {
        k--;
        adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] ele : times){
            int x = ele[0]-1;int y = ele[1] -1; int z = ele[2];
            adj.get(x).add(new Integer[]{y,z});
        }
        pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer[] a,Integer[]b){
                return a[1]-b[1];
            }
        });
        pq.add(new Integer[]{k,0});
        visited  = new HashSet<>();
        int[] distance = new int[n];
        Arrays.fill(distance,-1);
        dijkstras(distance);
        int max = 0;
        for(int ele : distance){
            if(ele==-1)return -1;
            max = Math.max(max,ele);
        }
        return max;
    }
    private void dijkstras(int[] distance){
        while(!pq.isEmpty()){
            Integer[] parent = pq.poll();
            // System.out.println(Arrays.toString(parent));
            if(visited.contains(parent[0]))continue;
            visited.add(parent[0]);
            distance[parent[0]] = parent[1];
            for(Integer[] neig : adj.get(parent[0])){
                if(!visited.contains(neig[0]))
                    pq.add(new Integer[]{neig[0],parent[1]+neig[1]});
            }   
        }
    }
}
