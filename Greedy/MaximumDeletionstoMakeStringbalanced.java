// time and space complexity : O(N)
/*
  --> Approach :
  --> We can have string like 'aaaaaa' or'bbbbbbb' or 'aabbbbb' but we can not have string like 'aaabaabaaa'
  --> So can fin out what maximum length balanced string we can make.
  --> Then removals = s.length() - maximum length of balanced string.
  --> To make a balanced string, we can consider 3 cases :
      --> All 'a' on left and all 'a' on right .(When balance string have 'a' only)
      --> All 'b' on left and all 'b' on right . (When balance string have 'b' only)
      --> All 'a' in left and all 'b' on right . (When balance string have 'ab' only)
*/
class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] aPrefix = new int[n];
        int[] bPrefix = new int[n];
        if(s.charAt(0)=='a')aPrefix[0]++;
            else bPrefix[0]++;
        for(var i=1;i<n;i++){
            char ch = s.charAt(i);
            aPrefix[i] = aPrefix[i-1];
            bPrefix[i] = bPrefix[i-1];
            if(ch=='a')aPrefix[i]++;
            else bPrefix[i]++;
        }
        int maxLen = 0;
        for(var i=0;i<n;i++){
            int aOnLeft = aPrefix[i];
            int aOnRight = aPrefix[n-1] - aOnLeft;
            int bOnLeft = bPrefix[i];
            int bOnRight = bPrefix[n-1] - bOnLeft;
            maxLen = Math.max(maxLen,aOnLeft + aOnRight);   // string having a only.
            maxLen = Math.max(maxLen,bOnLeft + bOnRight);    // string having b only.
            maxLen = Math.max(maxLen,aOnLeft + bOnRight);   // string having ab only.
        }
        return n - maxLen;
    }
}
