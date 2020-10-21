// a O(n) time , O(n) space solution
class Solution {
    public int scoreOfParentheses(String S) {
       Stack<Integer> st = new Stack<>();
        for(char c : S.toCharArray()){
            if(c==')'){
                int x = 0;
                while(!st.isEmpty() && st.peek()!=0)x+=st.pop();
                st.pop();
                st.push(Math.max(2*x,1));
            }
            else st.push(0);
        }
        int x = 0;
        while(!st.isEmpty())x+=st.pop();
        return x;
    }
}
