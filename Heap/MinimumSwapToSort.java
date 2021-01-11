  //problem link : https://practice.geeksforgeeks.org/problems/minimum-swaps/1/?track=DSASP-Graph&batchId=154#
  // problem link : https://www.hackerrank.com/challenges/minimum-swaps-2/problem
    
    
    // naive solution time complexity O(n^2)
    //approach is same of selection sort
    // for every i = n-1 to 0 do following
    // find the maximum element and its index(maxIndex) from 0 to i
    // swap element at i with maxIndex and increment the counter for every swap
    public int minSwaps(int arr[]) {
        int c =0;
        int n = arr.length;
        for(int i=n-1;i>=0;i--){
            int max = 0 ;
            int maxIndex = -1;
            for(int j=0;j<i+1;j++){
                if(max<arr[j]){
                    max = arr[j];
                    maxIndex = j;
                }
            }
            if(max==arr[i])continue;
            c++;
            int t = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = t;
        }
        return c;
    }
    // efficient solution time complexity O(nlogn)
    // approach is same as of above solution
    // instead of finding maximum element from 0 to i, we can use hashmap to store indexes
    // we can use max heap to find maximum element and map to find the index of maximum element
    // suppose max element is a index maxIndex, we will swap it with element at ith index
    // after swapping, we will update the index of element at ith to maxIndex in map also
    public int minSwapsEfficient(int arr[]) {
        int c = 0;
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(arr[i], i);
        for (int i = 0; i < n; i++) pq.add(arr[i]);
        for (int i = n - 1; i >= 0; i--) {
            int max = pq.poll();
            int maxIndex = map.get(max);
            if (max == arr[i]) continue;
            c++;
            int t = arr[i];
            map.put(t, maxIndex);
            arr[i] = max;
            arr[maxIndex] = t;
        }
        return c;
    }
