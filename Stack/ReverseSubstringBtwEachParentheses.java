// O(n^2) solution cuz of reverse() operation
class Solution {
    public String reverseParentheses(String s) { 
        Stack<String> st = new Stack<>();
        s = "("+s+")";  //handeling corner case
        for(char c : s.toCharArray()){
            if(c==')'){
                StringBuilder str = new StringBuilder();
                String t;
                while(!(t=st.pop()).equals("("))str.append(t);
                st.push(str.reverse().toString());
            }
            else st.push(c+"");
        }
 
        return st.pop();
    }
}
