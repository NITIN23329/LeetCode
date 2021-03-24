// time complexity : O(n^2), and space complexity O(N)
/*
  approach for every i, find the maxmimum palindromic substring with odd and even length and having ith char in middle of the paliondrome.
  return the substring havinf max length
*/
class Solution {
    public String longestPalindrome(String s) {
        int[] pos = new int[]{0,0};
        for(int i=0;i<s.length();i++){
            int[] odd = findPos(s,i,i);
            int[] even = findPos(s,i+1,i);
            pos = max(pos,odd);
            pos = max(pos,even);
        }
        return s.substring(pos[0],pos[1]+1);
    }
    private int[] findPos(String s,int l,int r){
            while(l-1>=0 && r+1<s.length() && s.charAt(l-1)==s.charAt(r+1)){
                l--;r++;
            }
        return new int[]{l,r};
           
    }
    private int[] max(int[] a,int[] b){
        if(a[1]-a[0]+1>b[1]-b[0]+1)return a;
        return b;
    }
}
