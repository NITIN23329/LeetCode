// time and space complexity O(n^2)
/*
    approach : see approach 2 of #https://leetcode.com/problems/palindromic-substrings/solution/
        --> suppose there is a string c0c1c2c3c4, if we know that if c1c2c3 is a palindrome and if c0==c4, then c0c1c2c3c4 is also a palindrome
        --> and if c1c2c3 then there is no way for c0c1c2c3c4 be a palindrome.
        --> example "abcba" , we can see that "bcb" is palindrome and 'a'(start) == 'a'(end) we know that "abcba" is also a palindrome
        --> to check a string of length 7, we first find whether the substring 1 to 6 (length 5) is palindrome or not
        --> i.e. to find if larger string is a palindrome or not, we first find the info about smaller strings.
        --> i.e. we first hold info for all stubstring of length 1
        --> then we find info for all substring of length 2 using info of substring fo length 1 and so on
        --> briefly , to find if palin[i][j] is substring or not, find palin[i+1][j-1] is palindrome or not and s[i]==s[j].
*/

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] palin = new boolean[n][n];
        int ans = 0;
        for(int gap=0;gap<n;gap++)
            for(int i=0;i<n-gap;i++){
                int j = i+gap;
                palin[i][j] = (i+1>j-1? true : palin[i+1][j-1]) && s.charAt(i)==s.charAt(j);
                ans+=palin[i][j]? 1 : 0;
            }
        return ans;
    }
}
