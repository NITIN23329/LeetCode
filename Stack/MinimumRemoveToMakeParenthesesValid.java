class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        Set<Integer> set= new HashSet<>();
        int z=0;
        for(char c:s.toCharArray()){
            if(c==')'){
                if(!st.isEmpty() && s.charAt(st.peek())=='('){
                    set.remove(st.pop());
                }
                else {
                    st.push(z);
                    set.add(z);
                }
            }
            else if(c=='('){
                st.push(z);
                set.add(z);
            }
            z++;
        }
        
        StringBuilder str = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(set.contains(i))continue;
            str.append(s.charAt(i));
        }
        return str.toString();
    }
}
