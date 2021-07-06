// time complexity : O(nlogn), space complexity : O(n)
/*
  --> Approach :
    --> Well we just need the length of longest subaray, what we can do is we maintain a sorted sub-array using TreeMap.
    --> We use a queue to store a continuous subarray and we guarentee this subarray alwasy have diff <= limit.
    --> In order to make the queue in sorted order, we use treemap.
    --> When we are at element x, we first check if any of element in previous subarray got a problem which current element x, i.e. abs(prev element - x)>limit.
    --> The possible element that got a problem are the min and max value in the subarray hence we check using a sorted Treemap.
    --> if they got a problem, we pop all elements from the subarray that was stored in queue and treemap until the problem causing element got removed.
    --> after removing all such problem causing element, we can peacefully add current element x.
*/
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> dq = new ArrayDeque<>();
        int len = 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int ele : nums){
            while(!dq.isEmpty() && (Math.abs(map.firstKey() - ele ) >limit ||
                  Math.abs(map.lastKey() - ele )>limit)){
                int x = Math.abs(map.lastKey() - ele )>limit?map.lastKey():map.firstKey();
                int curr;
                do{
                    curr = dq.poll();
                    if(map.get(curr) - 1 == 0)map.remove(curr);
                    else map.put(curr,map.get(curr) - 1);
                }while(!dq.isEmpty() && curr != x);
            }
            map.put(ele,map.getOrDefault(ele,0)+1);
            dq.add(ele);
            len = Math.max(len,dq.size());
        }
        return len;
    }
}
