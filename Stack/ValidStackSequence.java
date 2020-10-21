//time O(N)   , space O(n)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int i1=0,i2=0;
        int n=  pushed.length;
        while(i1<n || i2<n){
          if(i1==n){
              if(st.pop()!=popped[i2])return false;
              else i2++;
          }
          else if(popped[i2]==pushed[i1]){
               i1++;
               i2++;
           }
            else if(!st.isEmpty() && st.peek()==popped[i2]){
                st.pop();
                i2++;
            }
            else{
                
                st.push(pushed[i1]);
                i1++;
            }
            
        }
        return st.isEmpty();
    }
}
