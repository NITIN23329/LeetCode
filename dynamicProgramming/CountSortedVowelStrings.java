// time complexity : O(2^n)
/*  approach :  
        --> for every char in {a,e,i,o,u} either we can take a particualr char or not
        --> if we take a character , we can again start from that character itself from next recursive call
        --> if we dont take character , now we can only take character from next index only.
        --> base case is either we formed string of required length or we exhaust all available character to add.
*/
class Solution {
    public int countVowelStrings(int n) {
        char[] vowels = new char[]{'a','e','i','o','u'};
        return recursive("",0,vowels,n);
    }
    private int recursive(String curr,int start,char[] vowels,int n){
        if(curr.length()==n)return 1;
        if(start==5)return 0;
        char ch = vowels[start];
        return recursive(curr+ch,start,vowels,n) + recursive(curr,start+1,vowels,n);
    }
}
// time and space complexity : O(5*n)
// memoization of above recursive approach .
// one optimization is instead of using curr as a string ,we will take currLength which repersents length of current string
// we can do this cuz all the string formed are itself sorted so no need to check for sorted string.
class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n][5];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
        return recursive(0,0,n,dp);
    }
    private int recursive(int currLength,int start,int n,int[][] dp){
        if(currLength==n)return 1;
        if(start==5)return 0;
        if(dp[currLength][start]!=-1)return dp[currLength][start];
        return dp[currLength][start] =  recursive(currLength+1,start,n,dp) + 
            recursive(currLength,start+1,n,dp);
    }
}
