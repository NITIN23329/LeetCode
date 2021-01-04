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
//time complexity O((nums1.length + k)*log(nums1.length))
/*  approach : same as merging k sorted arrays using min heap
        --> take a min heap which has first element as nums1 element and index of nums2 element as 2nd element
        --> find the minimim sum pair , increment the index of num2 for next pair
*/
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]+nums2[a[1]]-b[0]-nums2[b[1]]));
        List<List<Integer>> list = new ArrayList<>();
        if(nums2.length==0 || nums1.length==0)return list;
        for(int ele : nums1)pq.add(new int[]{ele,0});
        while(k-->0 && !pq.isEmpty()){
            int[] x = pq.poll();
            List<Integer> t = new ArrayList<>();
            t.add(x[0]);t.add(nums2[x[1]]);
            list.add(t);
            if(x[1]+1==nums2.length)continue;
            x[1]++;
            pq.add(x);
        }
        return list;
    }
}
