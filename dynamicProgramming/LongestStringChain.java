// time complexity O(16*n^2) and space complexity O(n)
/*
  approach : Variation of LIS
    --> sort the words[] accoring to length
    --> for j<i , check if words[j] is a predecessor of word[i] or not
    --> if yes , then String chain length ending at word[j] + 1 = String chain length ending at word[i] can be a potential answer
*/
class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->(a.length()-b.length()));
        int n = words.length;
        int[] dp = new int[n];
        int max = 1;
        for(int i=0;i<n;i++){
            dp[i] = 1;
             for(int j=0;j<i;j++)
                if(isValid(words[i],words[j]))
                    dp[i] = Math.max(dp[i],1 + dp[j]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    private boolean isValid(String s,String t){
        if(s.length()!=t.length()+1)return false;
        int changes = 0;
        int i = 0,j = 0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)!=t.charAt(j)){
                i++;
                changes++;
            }
            else{
                i++;j++;
            }
        }
        changes+=s.length()-i;
        return changes==1;
    }
           
}
