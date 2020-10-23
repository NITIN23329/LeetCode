//time O(4n)
class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(st.size()>1){
                String str = ""+c+st.pop()+st.pop();
                if(!str.equals("cba")){
                    for(int i=2;i>=0;i--)st.push(str.charAt(i));
                }
            }
            else st.push(c);
        }
        return st.isEmpty();
    }
}
//time O(2n) solution
class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(st.size()>1){
               if(c=='c' && st.pop()!='b')return false;
               if(c=='c' && st.pop()!='a')return false;
               if(c!='c')st.push(c);
            }
            else st.push(c);
        }
        return st.isEmpty();
    }
}
