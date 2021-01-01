//time complexity : O(nlogk),space O(k)
/*  approach :
      --> maintain a max heap of the least distant k elements
      --> if we encounter a point having distance < top element of heap , we pop top and add current element
*/
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Dis> pq = new PriorityQueue<>(new Comparator<Dis>(){
            @Override
            public int compare(Dis d1,Dis d2){
                 if(d2.dis>d1.dis)return 1;
                 if(d2.dis<d1.dis)return -1;
                return 0;
                
            }
        });
        for(int[] p : points){
            double d = Math.sqrt(p[0]*p[0]+p[1]*p[1]);
            if(pq.size()<k)pq.add(new Dis(d,p));
            else if(pq.size()==k && pq.peek().dis>d){
                pq.poll();
                pq.add(new Dis(d,p));
            }
        }
        int[][] res = new int[pq.size()][];
        for(int i=0;i<res.length;i++)
            res[i] = pq.poll().point;
        return res;
    }
}
class Dis{
    double dis;
    int[] point;
    public Dis(double d, int[] p){
        dis=d;
        point=p;
    }
}
