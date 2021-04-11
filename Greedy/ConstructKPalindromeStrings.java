// time complexity : O(n) and space complexity : O(1)
/*
    --> approach :
    --> The best approach is for all k-1 strings, put only 1 character is each of them and put rest n-k+1 charcter in kth string and see if that is possible or not.
    --> Let reqLength = n - k + 1 be that length of kth string.
    --> if reqLength <=0 , return false as string contains atleast 1 charater.
    --> Out of given string s, find maximum length of palindromic string out of it.
    --> Then we take n-k+1 characters from s then rest will be taken by k-1 string 
    -->if maximum length of palindromic string >= reqLength retur true else false.
*/
class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        for(char c: s.toCharArray())freq[c-'a']++;
        boolean isOddPossible = false;
        int maxPalindromicLength = 0;
        for(int i=0;i<26;i++){
            maxPalindromicLength += 2 * (freq[i]/2);
            if(freq[i]%2==1)isOddPossible = true;
        }
        int reqLength = n - k + 1;
        if(reqLength<=0)return false;
        if(isOddPossible)maxPalindromicLength++;
        return reqLength<=maxPalindromicLength;
    }
}
