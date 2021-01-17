// time complexity O(elogv) , space complexity O(v)
/*  approach :
      --> apply dijkstras's algo
      --> for an edge from i to j, its path probablility or edge weight = probability to reach i * probability of edge i to j.
      --> we need to traverse highest probability edge first using max heap
*/
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<double[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new double[]{edges[i][1]+0d,succProb[i]});
            adj.get(edges[i][1]).add(new double[]{edges[i][0]+0d,succProb[i]});
        }
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->(b[1]>a[1]?1:-1));
        boolean[] isVisited = new boolean[n];
        double[] prob = new double[n];
        pq.add(new double[]{start+0d,1d});
        while(!pq.isEmpty()){
            double[] x = pq.poll();
            if(x[0]==end)return x[1];
            if(isVisited[(int)x[0]])continue;
            isVisited[(int)x[0]] = true;
            prob[(int)x[0]] = x[1];
            for(double[] neig : adj.get((int)x[0])){
                double currP = x[1]*neig[1];
                if(!isVisited[(int)neig[0]] && currP>prob[(int)neig[0]]){
                    pq.add(new double[]{neig[0],currP});
                    prob[(int)neig[0]] = currP;
                }
            }
        }
        return 0;
    }
}
