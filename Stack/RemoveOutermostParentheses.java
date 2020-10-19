//using StringBuilder and ArrayList
// stack will be empty after processing every primitive string
class Solution {
    public String removeOuterParentheses(String S) {
        Stack<Character> st  = new Stack<>();
        ArrayList<Character> list = new ArrayList<>();
        boolean isAdd=false;
        for(int i=0;i<S.length();i++){
            Character ch = S.charAt(i);
            if(ch=='(')st.push(ch);
            else st.pop();
            if(st.isEmpty()){
                isAdd = false;
            }else{
                if(!isAdd)isAdd = true;
                else    list.add(ch);
            }
        }
        StringBuilder str = new StringBuilder();
        for(Character ele : list)str.append(ele);
        return str.toString();
    }
}

// no of open brackets = no of closed brackets for primitive string
class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder str = new StringBuilder();
        int c=0;
        for(char ch : S.toCharArray()){
            if(ch=='(' && c>0)
                str.append(ch);
            else if(ch==')' && c>1)
                str.append(ch);
            if(ch=='(')c++;
            else c--;
        }
        return str.toString();
    }
}
