// time complexity of addNum() : O(2*log(n/2)) , findMedian() : O(1)
/*  approach :
      --> assume we are given an sorted array of even size and we need to find median
      --> we will make 2 priority queues : one is min heap for later half elements of array so that n/2+1 th term at top
      --> and a max heap of former half elements of array so n/2 th term at top and the we calculate mean by taking avg of top element in both pq.
      --> if we get element < max Heaps top, then this element must lies in former half so add it max heap.
      --> if maxHeap.size()> minHeap.size(), we will pop() top and add to minHeap
      --> if we get element> maxHeap top , this element must lies in later half , so add it to min heap
      --> if minHeap.size()==maxHeap.size()+1, pop top and add to maxHeap
      --> minHeap.size()>=maxHeap.size() except for first element. so minHeap's top will be the median when n is odd. for first element maxHeap top is median
      
*/
class MedianFinder {
    PriorityQueue<Integer> minHeap,maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b)->(b-a));
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty())maxHeap.add(num);
        else if(maxHeap.peek()<num){
            minHeap.add(num);
            if(minHeap.size()==maxHeap.size()+2)maxHeap.add(minHeap.poll());
        }
        else {
            maxHeap.add(num);
            if(maxHeap.size()>minHeap.size())minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        double d = 0d;
        if(minHeap.size()==maxHeap.size())d = (minHeap.peek()+maxHeap.peek())/2.0;
        else d = minHeap.isEmpty()? maxHeap.peek() : minHeap.peek();
        return d;
    }
}
