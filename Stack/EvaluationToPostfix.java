class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> dq = new ArrayDeque<>();
        for(String ele : tokens){
            switch(ele){
                case "+": dq.push(dq.pop()+dq.pop());
                          break;
                case "*": dq.push(dq.pop()*dq.pop());
                          break;
                case "-": dq.push(-1*(dq.pop()-dq.pop()));
                          break;
                case "/": int x = dq.pop();
                          dq.push(dq.pop()/x);
                          break;    
                default:  dq.push(Integer.parseInt(ele));             
            }
        }
        return dq.pop();
    }
}
