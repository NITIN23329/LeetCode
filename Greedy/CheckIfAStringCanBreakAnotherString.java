// time and space complexity : O(N), space complexity O(1)
/*
    --> A O(nlogn) approach would be to sort both strings and check for every s1[i]>=s2[i] or every s2[i]>=s1[i].
    --> From this we can think of O(n) approach.
    --> First we count freq of each alphabets for both s1 and s2 and store them in an array[26].
    --> Let s2 can break s1. So # of 'a' in s2 <= # of 'a' in s1 and # of 'a' + 'b' in s2 < = # of 'a' + 'b' in s1 and so on. Example s2 = 'abccc'and s1 = 'abbbb'.
    --> Basically # of character from 'a' to x in s2 <= # of characters from 'a' to x in s1. 
    --> So check that the prefixSum of s2 <= prefixSum if s1 for every x = 'a' to 'z'
*/
class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int n = s1.length();
        int [] freq1 = new int[26];
        int [] freq2 = new int[26];
        countFreq(freq1,s1);
        countFreq(freq2,s2);
        return canBreak(freq1,freq2) || canBreak(freq2,freq1);
    }
    private void countFreq(int[] freq,String s){
        for(char ch : s.toCharArray())
            freq[ch-'a']++;
    }
    private boolean canBreak(int[] a,int[] b){
    // check if a cuts b 
        int prefixSum1 = 0;
        int prefixSum2 = 0;
        for(int i=0;i<26;i++){
            prefixSum1+=a[i];
            prefixSum2 += b[i];
            if(prefixSum1>prefixSum2)return false;
        }
        return true;
    }
}
