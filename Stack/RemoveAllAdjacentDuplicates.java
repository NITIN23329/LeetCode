	//time O(n) space O(n)  ,  using 2 stacks
  // ArrayDeque is likely to be faster than Stack when used as a stack, and faster than LinkedList when used as a queue.
  /* the reason is that the grow() in stack increases the stack by 50%(10,15, 22, 33, 49, 73, 109, 163, 244, 366...) 
   *while ArrayDeque size grows by power of 2 (16,32, 64, 128, 256,...)
   * so ArrayDeque has less resizing and reallocting memory operations(grow()) than stack and coping 
   */
	class Solution {
		public String removeDuplicates(String s, int k) {
    //Deque is prefered because it is dynamically allocated while stack 
			Deque<Character> s1 = new ArrayDeque<>();
			Deque<Integer> s2 = new ArrayDeque<>();
			for(char c : s.toCharArray()){
				if(s1.isEmpty() || s1.peek()!=c){
					s1.push(c);
					s2.push(1);
				}
				else{
					int x = s2.pop()+1;
					if(x==k)s1.pop();
					else s2.push(x);
				 }
			}
			StringBuilder sb = new StringBuilder();
			while(!s1.isEmpty()){
				int x = s2.pop();
				char c = s1.pop();
				for(int i=0;i<x;i++)sb.append(c);
			}
			return sb.reverse().toString();
		}
	}
  
