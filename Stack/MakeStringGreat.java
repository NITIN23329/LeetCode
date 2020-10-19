class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(st.isEmpty()){
                st.push(c);
                continue;
            }
            if(Math.abs(st.peek()-c)==32)st.pop();  // diff btw lower and upper case is 32
            else st.push(c);
        }
        StringBuilder str = new StringBuilder();
        for(Character ele : st)str.append(ele);
        return str.toString();
    }
}
