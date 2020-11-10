//time O(n) space O(n)

class solve{
	public static String infixToPostfix(String exp) {
		Deque<Character> dq = new ArrayDeque<>();
		StringBuilder str = new StringBuilder();
		for(char c : exp.toCharArray()){
		    if(c=='(')dq.push('(');
		    else if(c==')'){
		        while(dq.peek()!='(') str.append(dq.pop());
		        dq.pop();
		    }
		    else if(c=='^'||c=='*'||c=='/'||c=='+' || c=='-'){
		        while(!dq.isEmpty() && dq.peek()!='(' && priority(dq.peek(),c))
		            str.append(dq.pop());
		        dq.push(c);
		    }
		    else str.append(c);
		}
		while(!dq.isEmpty())str.append(dq.pop());
		return str.toString();
	} 
	private static boolean priority(char a, char b){
	    if(a=='^')return true;
	    if(a=='*' || a=='/'){
	        if(b=='^')return false;
	        return true;
	    }
	    else {
	        if(b=='^' || b=='*' || b=='/')return false;
	        return true;
	    }
	}
}
