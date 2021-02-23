// time complexity O(n^2) and space complexity O(n)
/*  
  apporach :
    --> in case of LIS , we store  length in dp
    --> now we will also store freq of LIS,  dp[i] = {LIS length ,LIS freq}
    -->let i>j and nums[i] > nums[j] , if we know the LIS length and freq ending with nums[j]
    --> Then LIS length ending with nums[i] = LIS length ending with  nums[j] +1
    --> The freq of LIS ending with nums[i] = freq of LIS ending with nums[j]
    --> if more j exist such that LIS length ending at i = LIS length ending at j + 1 , we will add freq of all such j to get freq for i
    --> after finding length and freq for each i , find freq of LIS.
*/
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        int maxlen = 0;
        int maxfreq = 0;
        for(int i=0;i<n;i++){
            int len = 1;
            int freq = 1;
            for(int j=0;j<i;j++)
                if(nums[i]>nums[j]){
                    if(len<1+dp[j][0]){
                        len = 1+dp[j][0];
                        freq = dp[j][1];
                    }
                    else if(len==1+dp[j][0])
                        freq+=dp[j][1];
                }
            dp[i] = new int[]{len,freq};
            if(maxlen<dp[i][0]){
                maxlen = dp[i][0];
                maxfreq = dp[i][1];
            }
            else if(maxlen==dp[i][0])
                maxfreq+=dp[i][1];
        }
        return maxfreq;
    }
}
