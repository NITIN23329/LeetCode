// time and space complexity : O(n)
/*
  --> Suppose we have 3 character groups having # of occurence  = 5.
  -->Then we will consider 1 group of length 5 and then 1 group of length 4 and then 1 grouop of length 3 untill we have any group left.
  --> This give risies to a greedy solution.
*/
class Solution {
    public int minDeletions(String s) {
        int n = s.length();
        int[] charCount = new int[26];     // store # of occurence of each character
        for(char c : s.toCharArray())
            charCount[c-'a']++;
        int[] freqCount = new int[n+1];         // freqCount[i] = j means we have j # of characters having # of occurence  = i.
        for(int i=0;i<26;i++)
            freqCount[charCount[i]]++;
        int curr = 0;       // denotes the # of charcters groups that can be taken currently.
        int newStringLen = 0;   // will reprsents the length of string that can be formed after removal of some character.
        // we will traverse from n to 1 not from 1 to n cuz we can get s smaller substring of length m from a string of length n (m<=n) . Not vice versa.
        for(int i=n;i>0;i--){
            curr += freqCount[i];
            if(curr>0)newStringLen += i;    // if curr>0 then there is at least 1 character group from which we can take exacly i character
            curr = Math.max(0,curr-1);      // we will reduce our group #  after taking one. 
        }
        return n - newStringLen;        // this will give total # of deletions to be made.
    }
}
