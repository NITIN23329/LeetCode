// time complexity : O(n), space complexity : O(n)
/*
    --> The greedy approach is we can use 'a' from starting of string as much as we can so that the string will be lexiographically smallest.
    --> Or the other way to use 'z' as much as we can towards end to string. 
    --> if k >= 26 + (n - remaining length - 1), then we can use 'z' otherwise we will use character at k - remaining Length - 1(1 based index)
*/
class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(k>0){
            int x = Math.min(26,k - (n-sb.length()-1));
            sb.append((char)('a'+x-1));
            k-=x;
        }
        return sb.reverse().toString();
    }
}
