// time complexity : O(n), space complexity : O(1)
/*
    approach :
      --> Let say goal is 100, and sum(nums) = 10. Diff is 90, which is same case if goal is 10 and sum(nums) = 100. Still diff = 90.
      --> The only dfference is that in former case, we need element having +ve sign and in later one, we need same element but -ve sign.
      --> find the magniture of extra amount we need to add to the array. Which is req = abs(goal - sum(nums) )
      --> Now we need to find min # of elements whose sum = req.
      --> Since we can use an element having magnitude upto limit, we try to put as max elements having magnitude as possbile.
      --> then if req <= limit, we need only 1 element of magnitude limit - req.
*/
class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for(int ele : nums)sum+=ele;
        long req = Math.abs(goal-sum);
        long ans = req/limit + (req%limit==0?0:1);
        return (int)ans;
    }
}
