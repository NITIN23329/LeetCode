// time : O(n*n*log(n*n) + k*log(n*n))
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(List<Integer> a,List<Integer> b){
                return a.get(0)+a.get(1)-b.get(0)-b.get(1);
            }
        });
        for(int e1 : nums1)
            for(int e2 : nums2){
                List<Integer> l = new ArrayList<>();
                l.add(e1);l.add(e2);
                pq.add(l);
            }
        List<List<Integer>> res = new ArrayList<>();
        while(k-->0 && !pq.isEmpty())
            res.add(pq.poll());
        return res;
    }
}
