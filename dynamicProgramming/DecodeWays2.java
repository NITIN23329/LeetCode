// time and space complexity O(n)
/*
    approach :
        --> we can consider either current character or current + next character with some applied constraints.
        --> first consider only current character
        --> if curr = 0 return 0
        --> if curr == '*" , we can choose 9 possibilites:  '1','2','3','4','5','6','7','8','9' , so we do 9 * f(i+1),  else we do f(i+1)
        --> now we will consider current + next character only if curr =='1' or curr == '2' or curr = '*'. For curr>2 , current + next character can not be possible.
        --> now we will consider all possibibilites of  current + next character
        --> if curr == '*'
            -->if next == '*' , 15 possibilities are : 11-19 and 21-26
            --> if next <='6' , say 0 then 2 possibilities are there , 10 and 20
            --> if next>6 , say 18 then 1 possibility is 18
       --> else if next =='*'
            --> if curr == '1' we have 9 possibilities : 11 - 19
            --> if curr == '2' , we have 6 possibilities : 21- 26
      --> else if (curr+next) <=26 we have only 1 possibility.
      
*/
class Solution {
    int mod = (int)1e9+7;
    public int numDecodings(String s) {
        long[] dp = new long[s.length()];
        Arrays.fill(dp,-1);
        return (int)helper(s,0,dp);
    }
    private long helper(String s,int i,long[] dp){
        if(i==s.length())return 1;
        if(dp[i]!=-1)return dp[i];
        char curr = s.charAt(i);
        if(curr=='0')return 0L;
        long ans = 0L;
        if(curr=='*')ans = (ans +  9 * helper(s,i+1,dp))%mod;
        else ans = (ans + helper(s,i+1,dp))%mod;
        if(i+1<s.length() && (curr=='*'|| curr=='1' || curr=='2')){
            char next = s.charAt(i+1);
            if(curr=='*'){
                if(next == '*')ans = (ans +  15 * helper(s,i+2,dp))%mod;
                else if(next <='6')ans = (ans +  2 * helper(s,i+2,dp))%mod;
                else ans = (ans +  helper(s,i+2,dp))%mod;
            }
            else if(next=='*'){
                if(curr=='2') ans = (ans +  6*helper(s,i+2,dp))%mod;
                else ans = (ans +  9 * helper(s,i+2,dp))%mod;
            }
            else {
                if(curr=='2' && next <='6') ans = (ans +  helper(s,i+2,dp))%mod;
                if(curr=='1') ans = (ans +  helper(s,i+2,dp))%mod;
            }
        }
        return dp[i] = ans;
    }
}
// bottom up dp with time complexity O(n) and space compelxity : O(1)
class Solution {
    public int numDecodings(String s) {
        int n =s.length();
        int mod = (int)1e9+7;
        long i_plus_1 = 1;
        long i_plus_2 = 0;
        long ans = 0L;
        for(int i=n-1;i>=0;i--){
            char curr = s.charAt(i);
            ans = 0L;
            if(curr=='0'){
                i_plus_2 = i_plus_1;
                i_plus_1 = 0;
                continue;
            }
            if(curr=='*')ans = (ans +  9 * i_plus_1)%mod;
            else ans = (ans + i_plus_1)%mod;
            if(i+1<n && (curr=='*'|| curr=='1' || curr=='2')){
                char next = s.charAt(i+1);
                if(curr=='*'){
                    if(next == '*')ans = (ans +  15 * i_plus_2)%mod;
                    else if(next <='6')ans = (ans +  2 * i_plus_2)%mod;
                    else ans = (ans +  i_plus_2)%mod;
                }
                else if(next=='*'){
                    if(curr=='2') ans = (ans +  6*i_plus_2)%mod;
                    else ans = (ans +  9 * i_plus_2)%mod;
                }
                else {
                    if(curr=='2' && next <='6') ans = (ans +  i_plus_2)%mod;
                    if(curr=='1') ans = (ans + i_plus_2)%mod;
                }
            }
            i_plus_2 = i_plus_1;
            i_plus_1 = ans;
        }
        return (int)ans;
    }
}
