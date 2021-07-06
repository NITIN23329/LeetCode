
//using: DP, time and space complexity O(n).
/*
   Approach 1 : We keep track of open count. When ever we see a "(" we increment it and for ")" , we decrement it.
   --> If we sees a "*" it can be treat as "(" or ")" or "". Consider all cases and find all possible answer.
   --> At last if there should be no open brackets left in any combination, return true.
*/
class Solution {
    private boolean[][] dp,isCalc;
    public boolean checkValidString(String s) {
        int n = s.length();
        dp = new boolean[n+1][n+1];
        isCalc = new boolean[n+1][n+1];
        return memo(0,0,s.toCharArray());
    }
    private boolean memo(int i,int openCount,char[] str){
        if(openCount<0)return false;
        if(i==str.length)return openCount == 0;
        if(isCalc[i][openCount])return dp[i][openCount];
        boolean ans;
        if(str[i] == '(')
            ans =  memo(i+1,openCount+1,str);
        else if(str[i] == '*')
            ans =  memo(i+1,openCount+1,str) || memo(i+1,openCount,str) ||
                                memo(i+1,openCount-1,str);
        else ans =  memo(i+1,openCount-1,str);
        dp[i][openCount] = ans;
        isCalc[i][openCount] = true;
        return ans;
    }
}
// using Greedy approch. Time O(n) and space O(1)
/*
  --> Since we don't need to find a valid combination but only to tell if there is a valid combination exists or not, we can use the greedy approach
  --> First we traverse from left to right and treat every "*" as "(". if openCount is < 0 then a valid combination doesn't exists.
  --> Again we traverse from right to left and now treat every "*" as ")". if closeCount is <0 then a valid combination doesn't exists.
  --> Otherwise the exists a valid combination where we can use every "*" as "" or "(" or ")" .
*/
class Solution {
    public boolean checkValidString(String s) {
        int openCount = 0;
        for(char c : s.toCharArray()){
            if(c=='(' || c=='*')openCount++;
            else openCount--;
            if(openCount<0)return false;
        }
        int closeCount = 0;
        for(int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if(c ==')' || c=='*')closeCount++;
            else closeCount--;
            if(closeCount<0)return false;
        }
        return true;
    }
}
