// time complexity O (n^2) , with space complexity o(n)
/*
  approach : variation of LIS
  --> sort the clips according to increasing order of start time
  --> let dp[i] reprsents minimum # of clips required for interval 0 to clip[i][1] else dp[i] = n+1 if not possible
  --> note that if clip[i][0]==0 i.e. if clip start at 0, dp[i] = 1.
  --> we try to minimize for every clip[i][1] and atlast we return minimum clips for interval [0,T]
*/
class Solution {
    public int videoStitching(int[][] clips, int T) {
        // sort clips according to their start time.
        Arrays.sort(clips,(a,b)->(a[0]-b[0]));
        int n = clips.length;
        // corner case if T==0, we dont need any clips return 0
        if(T==0)return 0;
        int[] dp = new int[n];
        // if dp[i]==n+1, it means we can not find answer for time [0,clips[i][1]]
        Arrays.fill(dp,n+1);
        int min = n+1;
        for(int i=0;i<n;i++){
            if(clips[i][0]==0)dp[i] = 1;
            else{
                for(int j=0;j<i;j++)
                    if(dp[j]!=n+1 && clips[i][0]<=clips[j][1])
                        dp[i] = Math.min(dp[i],1 + dp[j]);
            }
            if(clips[i][1]>=T && dp[i]!=n+1) 
                min = Math.min(min,dp[i]);
        }
        return min==n+1? -1 : min;
    }
}
