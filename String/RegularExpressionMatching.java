// time complexity : O(2^nm) ==> loose bound
/*
  approach : consider different cases.
  --> if p[m-1]=='.', we can skip s[i] and goto f(n-1,m-1)
  --> if p[m-1] == '*', we can either take 0 instances of p[m-2] using f(n,m-2) or we can take some instances of p[m-2] using f(n-1,m)
  --> if m==0, then n.must be 0
  --> if n==0, then p[m-1] must be '*' and goto f(n,m-2)
  --> if p[m-1] is a charcter the p[m-1] must equal to s[n-1]
*/
class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s,p,s.length(),p.length());
    }
    private boolean helper(String s,String p,int n,int m){
        boolean ans;
        if(m==0) ans = n==0;
        else if(n==0){
            if(p.charAt(m-1)=='*') ans = helper(s,p,n,m-2);
            else ans = false;
        }
        else if(p.charAt(m-1)=='.') ans = helper(s,p,n-1,m-1);
        else if(p.charAt(m-1)=='*')
            ans = ((s.charAt(n-1)==p.charAt(m-2) || p.charAt(m-2)=='.') && helper(s,p,n-1,m)) || helper(s,p,n,m-2);
        else ans = s.charAt(n-1) == p.charAt(m-1) && helper(s,p,n-1,m-1);
        return ans;
        
    }
}
