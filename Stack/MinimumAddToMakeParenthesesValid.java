// time O(n) , space O(1)
class Solution {
    public int minAddToMakeValid(String S) {
        int open=0;
        int close = 0;
        for(char c : S.toCharArray()){
            if(c==')')
                if(open==0)close++;
                else open--;
            else open++;
        }
        return open+close;
    }
}
