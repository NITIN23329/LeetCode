// time complexity of add() is O(logn) 
/*  approach :
      --> maintain a min heap of size k. 
      --> min heap contains largest k elements out of n
      --> todo so , if min heap size==k , and if the incoming element is , top , we do nothing as kth largest sill remains same (top element)
      --> if the incomming element is > top , then we remove top and add the incoming element.
*/
class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k=k;
        for(int ele : nums){
            if(pq.size()==k && pq.peek()<ele){
                pq.poll();
                pq.add(ele);
            }else if(pq.size()<k)pq.add(ele);
        }
    }
    
    public int add(int val) {
        if(pq.size()==k && pq.peek()<val){
                pq.poll();
                pq.add(val);
        }else if(pq.size()<k)pq.add(val);
        int res = pq.peek();
        return res;
    }
}

