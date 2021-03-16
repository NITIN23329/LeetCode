// time complexity : O(nlog10(k)) , space complexity O(n)
/*
  for every i in 0 to n-1 , we run loop until val ==k, SInce val grows in power of 10 , # of times while loop run = 10^t = k
  => t = log10(k) , where t is # of time while loop runs. Hence time complexity O(nlog10k) = O(n), as log10(k) = 9
  
  approach :
      --> we start from a index i in s,
      --> initially val is s.charAt(i) , a single digit number
      --> on every iterations we will increase the length of val by 1 until val<=k
      --> if our val is from index i to x , our next recursive call will be done to index x+1.
      --> if s.charAt(i)==0 , we return 0
      --> if we reach to s.length() , it means we traversed every index and have created a valid array hence return 1.
*/
class Solution {
    public int numberOfArrays(String s, int k) {
        long[] dp = new long[s.length()];
        Arrays.fill(dp,-1);
        return (int)helper(s,0,k,dp);
    }
    private long helper(String s,int i,int k,long[] dp){
        if(i==s.length())return 1L;
        if(dp[i]!=-1)return dp[i];
        long val = s.charAt(i)-'0';
        if(val==0)return dp[i] = 0L;
        long ans = 0L;
        int x = i;
        while(val<=k){
            ans = (ans + helper(s,x+1,k,dp))%((int)1e9+7);
            x++;
            if(x==s.length())break;
            val = 10L*val + (s.charAt(x)-'0');
        }
        return dp[i] = ans;
    }
}
