// time and space complexity : O(n)
/*
    approach :
    part 1
      --> We will consider some first element and some last elements from nums whose sum = x.
      --> So we store prefix Sum in a Map with sum as key and index as value. We can take sum as key as, nums[i] != 0 .
      --> Then take suffixSum for every i = n-1 to i>=0, and check if( prefixSum.containsKey( x - current Suffix sum)). 
          --> if we we found an combination. Dont stop here, continue and you may get more optimal answer in future.
     --> Two corner cases are when we take only first elements and no last elements and when we take only last elements and no first elements.
     part 2
     --> Do we need to make a map of suffix sum and  iterate for prefix sum? Or Part 1 is sufficient.
     --> Suppose we get more optimal answer by iterating over prefix sum. Say this prefixSum will take take some suffixSum otherwise it will be the corner case.
     --> I claim that as we are considering some last elemnent, the current combination of first and last element is previouly considered by former part1.
     --> And this claim is true as the part 1 will consider every suffix combinations.
*/
class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        Map<Integer,Integer> leftPrefix = new HashMap<>();
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            leftPrefix.put(sum,i+1);
        }
        // case : dont take any right element.
        int removes = leftPrefix.getOrDefault(x,n+1);
        leftPrefix.put(0,0);  // dont take any element from left side.
        int rightSum = 0;
        for(int i=n-1;i>=0;i--){
            rightSum += nums[i];
            if(leftPrefix.containsKey(x - rightSum))
                removes = Math.min(removes,n - i + leftPrefix.get(x - rightSum));
        }
        return removes>n? -1 : removes;
    }
}
