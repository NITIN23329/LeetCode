class Solution {
    public String decodeString(String s) {
        Deque<String> dq = new ArrayDeque<>();  //stack
        StringBuilder num = new StringBuilder();
        StringBuilder str = new StringBuilder();
        s = "1["+s+']';   //handle base corner case.
        for(char c:s.toCharArray()){
            if(c=='['){
                if(!str.toString().isEmpty()){      //cases like ...2[z]abc3[deg]...here "abc" has no prefix integer. 
                    dq.push(str.toString());        //Here we are also adding "abc" to dq
                    str = new StringBuilder();
                }
                dq.push(num.toString());
                num = new StringBuilder();
            }
            else if(c==']'){
                while(!dq.isEmpty() && !(dq.peek().charAt(0) >='0' && dq.peek().charAt(0) <='9'))
                    str.insert(0, dq.pop());            //handle case when there are more than 1 consecutive strings in dq.
                int f = dq.isEmpty()? 1:Integer.parseInt(dq.pop());
                StringBuilder t = new StringBuilder();
                for(int i=0;i<f;i++)t.append(str);
                dq.push(t.toString());
                str = new StringBuilder();
            }
            else if(c>='0' && c<='9') num.append(c);
            else str.append(c);
        }
        return dq.pop();
    }
}
