// time complexity : O(NlogN), space complexity : O(1)
/*
    approach :
      --> We might be tempted to take min cost passengers first but that would be wrong. Why? Think of a counter test case.
      --> Let costs = [[100,109],[50,52]]. If we first take 50 , then total cost = 50 + 109 = 159.
      --> But the more optimal cost = 100 + 52 = 152.
      --> So how to proceed?. From this example we can see that taking that pair(a,b) whose |a-b| = larger is better.
      --> Why?, Consider [ [ c1, c1 + d1], [ c2 , c2 + d1 + d2 ]] .
      --> Cost 1 : c1 + c2 + d1 + d2, cost 2 : c1 + c2 + d1 . We can clearly see that cost 2 <= cost 1.
      --> Suppose a<b and |a-b| is big, if we dont take smaller valued city(a) now, then later on, we might ended up getting larger valued city(b).
          --> The diff btw these 2 cases cost is |a-b|,We dont want this, so we take those passengers first whose |a-b| is maximim first.
          --> And add min(a,b) to our answer. In this way we ensure that big values are not added to our answers.
      
*/
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,(a,b)->(Math.abs(b[0]-b[1]) - Math.abs(a[0]-a[1])));
        int aCity = 0;
        int bCity = 0;
        int n = costs.length/2;
        int ans = 0;
        for(int [] ele : costs){
            if(aCity == n)ans+=ele[1];
            else if(bCity == n)ans +=ele[0];
            else {
                if(ele[0]<=ele[1]){
                    ans += ele[0];
                    aCity++;
                }else {
                    ans += ele[1];
                    bCity++;
                }
            }
        }
        return ans;
    }
}
