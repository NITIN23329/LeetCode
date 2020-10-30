	//time O(n) , space O(n)
	/*
	try some test cases , you will observe that on moving left to right in the string,
	if we find a digit less than top of stack , we need to remove top and add current element to stack for k times.
	a corner case is like number 12345 , here we will not able to pop any item from stack , so take  nums.length()-k element from down of stack.
	*/
	class Solution {
		public String removeKdigits(String num, int k) {
			int z = num.length()-k;
			Deque<Character> dq = new ArrayDeque<>();
			for(char c: num.toCharArray()){
				while(!dq.isEmpty() && dq.peek()>c && k>0){
					dq.pop();
					k--;
				}
				dq.push(c);
			}
			StringBuilder str = new StringBuilder();
			boolean traling0 = true;      //used to remove trailing zeroes
			for(int i=0;i<z;i++){
				char c = dq.pollLast();
				if(c !='0')traling0=false;
				if(!traling0)
					str.append(c);
			}
			String res = str.toString();
			return res.isEmpty()? "0":res;
		}
	}
