//time O(elogv) , space O(e+v)
//approach : do dijkstra's algo from k-1
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] ele : times)
            adj.get(ele[0]-1).add(new int[]{ele[1]-1,ele[2]});
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        boolean[] isVisited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        pq.add(new int[]{k-1,0});
        while(!pq.isEmpty()){
            int[] x = pq.poll();
            if(isVisited[x[0]])continue;
            distance[x[0]] = x[1];
            isVisited[x[0]] = true;
            for(int[] neig : adj.get(x[0])){
                int currD = distance[x[0]]+neig[1];
                if(!isVisited[neig[0]] && currD<distance[neig[0]]){
                    distance[neig[0]] = currD;
                    pq.add(new int[]{neig[0],currD});
                }
            }
        }
        int max = 0;
        for(int ele : distance){
            if(ele==Integer.MAX_VALUE)return -1;
            max = Math.max(max,ele);
        }
        return max;
    }
}
