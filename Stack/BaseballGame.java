  class Solution {
      public int calPoints(String[] ops) {
          Stack<Integer> st = new Stack<>();
          int score = 0;
          for(String ele : ops){
              if(ele.equals("+")){
                  int x = st.pop();
                  int y = st.pop();
                  score+=x+y;
                  st.push(y);
                  st.push(x);
                  st.push(x+y);
              }
              else if(ele.equals("D")){
                  int x = st.peek();
                  score+=2*x;
                  st.push(2*x);
              }
              else if(ele.equals("C")){
                  int x =st.pop();
                  score-=x;
              }
              else {
                  int x = Integer.parseInt(ele);
                  st.push(x);
                  score+=x;
              }
          }
          return score;
      }
  }
