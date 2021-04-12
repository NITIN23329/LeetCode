// time complexity : O(n), auxilarry space complexity : O(1)
/*
  approach : 
  --> Suppose there is a contigious group of same character say 'baaaab'. Not it will be reduced to a single 'a' only('bab').
  --> Now question arrises, which 'a's should we remove and which 'a' will be left at last. 
  --> To minimize the cost we must left the most costly 'a' and remove all other 'a's.
*/
class Solution {
    public int minCost(String s, int[] cost) {
        int totalCost = 0;
        int n = s.length();
        for(int start=0;start<n;){
            int end = start + 1;
            int currCost = cost[start];
            int currMax = cost[start];
            while(end<n && s.charAt(end)==s.charAt(start)){
                currCost+=cost[end];
                currMax = Math.max(currMax,cost[end]);
                end++;
            }
            if(end>start+1)
                totalCost += currCost - currMax;
            start = end;
        }
        return totalCost;
    }
}
