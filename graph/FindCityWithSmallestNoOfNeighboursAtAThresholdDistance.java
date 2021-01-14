// time O(v*e*logv)
/*  approach :
      --> for every city , using dijkstras algo find all city atmost at a distance of distanceThreshold
      --> the city which has minimum city visitable is out answer
*/
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] ele : edges){
            adj.get(ele[0]).add(new int[]{ele[1],ele[2]});
            adj.get(ele[1]).add(new int[]{ele[0],ele[2]});
        }
        int cityVisitable = n;
        int city = n;
        for(int i=0;i<n;i++){
            int count = dijkstras(adj,i,distanceThreshold,n);
            if(count<=cityVisitable){
                cityVisitable = count;
                city = i;
            }
        }
        return city;
    }
    private int dijkstras( List<List<int[]>> adj, int start,int k,int n){
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        boolean[] isVisited = new boolean[n];
        pq.add(new int[]{start,0});
        while(!pq.isEmpty()){
            int[] x = pq.poll();
            if(isVisited[x[0]])continue;
            isVisited[x[0]] = true;
            distance[x[0]] = x[1];
            for(int[] neig : adj.get(x[0])){
                int currD = distance[x[0]]+neig[1];
                if(currD>k)continue;
                if(currD<distance[neig[0]]){
                    distance[neig[0]] = currD;
                    pq.add(new int[]{neig[0],currD});
                }
            }
        }
        int count = 0;
        for(int ele : distance)if(ele<=k)count++;
        return count;
    }
}
