// time complexity O(min(n^2 ,n * shelf_width)) 
/*
  --> let say dp[i] represents solution for which our current shelf ends with element at index i.
  --> Find how much you can accumulate in current shelf.
  --> we goto i-1th element and see if it can be placed on current shelf or not? ( width of i-1 + width of i <=shelf_width)
  --> if yes we take max height of both of them and answer for dp[i] = maxHeight + dp[i-2] (as we have take i-1th and ith element in current shelf)
  --> similarly goto i-2th element and see if it can be placed on current shelf or not? (width of i-2 + width of i-1 + width of i <=shelf_width)
  --> if yes we take max height of all three of them and answer for dp[i] = maxHeight + dp[i-3] (as we have take i-2th,i-1th and ith element in current shelf)
  --> do this untill we have sufficient space to add an element to current shelf(curr_width<=shelf_width) or you reach index -1(no element left).
  --> then take min of all possible answers calculated above to get answer for dp[i].
  
*/
class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            int maxHeight = 0;
            int curr_width = 0;
            dp[i] = Integer.MAX_VALUE;
            for(int j=i;j>=0;j--){
                maxHeight = Math.max(maxHeight,books[j][1]);
                curr_width+=books[j][0];
                if(curr_width>shelf_width)break;
                dp[i] = Math.min(dp[i],(j==0?0:dp[j-1])+maxHeight);
            }
        }
        return dp[n-1];
    }
}
