// time complexity : O(n), space complexity : O(1)
/*
  approach : find the length of substring having same character = x , their contribution = (x)*(x+1)/2. Why?
        --> there are exactly x strings of length 1, x-1 strings of length 2, x-2 strings of length 3......1 string of length x. Add them.
*/
class Solution {
    public int countHomogenous(String str) {
        char prev = '.';    // dummy char used for 1st comaprision;
        long ans = 0;
        long same = 1;
        int mod = (int)1e9+7;
        for(char curr : str.toCharArray()){
            if(prev == curr)same++;
            else same=1;
            ans+=same;
            ans %= mod;
            prev = curr;
        }
        return (int)ans;
    }
}
