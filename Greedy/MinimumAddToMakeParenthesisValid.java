// time complexity : o(n), space complexity O(1)
/*
  approach :
    --> keep hold of open paranthesis, if at any point open <0, we need extra -open opening parenthesis.
    --> After traversing fully, if open>0, we need extra open closing parenthesis
*/
class Solution {
    public int minAddToMakeValid(String S) {
        int open =0;
        int ans = 0;
        for(char ch : S.toCharArray()){
            if(ch=='(')open++;
            if(ch==')')open--;
            if(open<0){
                ans++;
                open=0;
            }
        }
        return open + ans;
    }
}
