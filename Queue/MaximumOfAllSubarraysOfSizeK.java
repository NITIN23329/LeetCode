//# problem link : https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
//time O(N) , space O(N)
/* approach : maintain a dq yo store index, leftMost items is the most recent item , and rightMost item is the least recent item .
remove  from dq(remove from left to right) untill the current element is > dq elemnts from left to right.
else add current item from left side . 
The right most element always holds maximum element for current subarray of size k.
If the rightMost element goes out of current window , remove that element from right.
*/
class solve{
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && arr[dq.peek()]<arr[i])dq.pop();
            dq.push(i);
        }
        list.add(arr[dq.peekLast()]);
        
        for(int i=k;i<n;i++){
            if(dq.peekLast()==i-k)dq.removeLast();
            while(!dq.isEmpty() && arr[dq.peek()]<arr[i])dq.pop();
            dq.push(i);
            list.add(arr[dq.peekLast()]);
        }
        return list;
    
    }
    
}
// time O(nlogn)  , space O(n)
// arroach : using maxHeap.
class solve{
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++)pq.add(arr[i]);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(pq.peek());
        for(int i=k;i<n;i++){
            pq.remove(arr[i-k]);
            pq.add(arr[i]);
            list.add(pq.peek());
            
        }
        return list;
    }
}
