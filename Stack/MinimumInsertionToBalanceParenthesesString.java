/*
" (..........(.........) .........) ....... )...........(...........(........ ).........).........) ......(......... )........(......... )......... ) ....... ).........)"
" 0.........1........2........3 .......4...........5..........6......7.......8.........9.......10.....11......12......13.......14......15......16"

Here consecutive means we can only merge 2 " ) " with 1 "(" only when 2 ")" are at consecutive indices.
In this Example,
1 merged with 2 & 3
6 merged with 7 & 8
12 merged with 13 & 14
So the final String becomes :
" (........ ).......... (.........).......(........).......... ).........)"
0.........4..........5........9.....10....11.......15.......16
Here 10 will not merge with11 & 15 cuz they are not at consecutive index.
So ,
0 & 4 require 1 ')'
5 & 9 requires 1 ')'
10 & 11 requires 1 ')'
15 & 16 requires 1 '('
Hence final result is 4
*/
//time O(N) , space o(N) : Stack is used
class Solution {
    public int minInsertions(String s) {
        int res = 0;
        Deque<Character> dq = new ArrayDeque<>();
        for(int i=0;i<s.length();){
            char c = s.charAt(i);
            //if c=='(' simply push
            if(c=='('){
                dq.push(c);
                i++;
            }
            else {
                char d ='.'; //if c is the last character d='.' else d=next character
                if(i+1!=s.length())
                    d=s.charAt(i+1);
                if(dq.isEmpty()){   
                    res++;      // add '(' before c
                    if(d==')')  // case "())" , simply increment index by 2
                        i+=2;  
                    else {      //  case "()(" , add ')' after c , increment index by 1
                        res++;
                        i++;
                    }
                }
                else {              // stack always contains '('. so take '(' from stack before c
                    if(d==')')i+=2;  // case "())" , simply increment index by 2
                    else{            //  case "()(" , add ')' after c , increment index by 1
                        res++;
                        i++;
                    }
                    dq.pop();       //remove '(' from top of stack
                }
            }
        }
        res+=2*dq.size();       // stack contains unmerged "(" only . for ever "(" add 2")"
        return res;
    }
}
// optimization of above problem ,  remove stack 
//time O(N) , space O(1)
class Solution {
    public int minInsertions(String s) {
        int res = 0;
        int open = 0;   // contains no. of unmerged "("
        for(int i=0;i<s.length();){
            char c = s.charAt(i);
            if(c=='('){
                open++;
                i++;
            }
            else {
                char d ='.'; 
                if(i+1!=s.length())
                    d=s.charAt(i+1);
                if(open==0){   
                    res++;     
                    if(d==')') 
                        i+=2;  
                    else {      
                        res++;
                        i++;
                    }
                }
                else {             
                    if(d==')')i+=2; 
                    else{            
                        res++;
                        i++;
                    }
                   open--;     
                }
            }
        }
        res+=2*open;     
        return res;
    }
}
