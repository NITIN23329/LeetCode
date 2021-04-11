// time and space complexity : O(n)
/*
  --> Approach : Let array = {1,1,2,3,4,5} and let a group consists of only single distinct element like {1,1,1} or {2} .
  --> Find freq of each element and put it in a map. { 1->2, 2->1, 3->1, 4->1, 5->1} 
  --> let count[i] be stores the count of groups whose frequency = i. ( count[] = {0,4,1,0,0,0} ) 
  --> then traverse from i = n, to i=0 ( We need to remove largest size group first)
  --> let removed store the # of elements removed from array. And let req = (n/2 - removed) be the # of elements needed to be removed.
  --> If count[i] * i > req, then we would not need to remove all count[i] groups, we need to remove min # of groups such that removed >=n/2
  --> But how much groups we need to remove? We need aleast ceil(req/i) groups to remove so that removed >= n/2.
  --> From the taken array, let say we reached at i = 1, then removed = 2 and setSize = 1, and req = 2.
  --> Then we need to remove min(count[i],ceil(req/i)) = min(4,2/1) = 2 groups more.
  
*/

class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int ele : arr)
            freq.put(ele,freq.getOrDefault(ele,0)+1);
        int n = arr.length;
        int[] count = new int[n+1];
        for(int key: freq.keySet())
            count[freq.get(key)]++;
        int removed = 0;
        int setSize = 0;
        for(int i=n;i>0;i--){
            int req = n/2 - removed;
            setSize += Math.min(count[i],Math.ceil(req/(i+0d)));
            removed += Math.min(req,count[i]*i);
            if(removed>=n/2)break;
        }
        return setSize;
    }
}
