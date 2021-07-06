/*  Time : O(1) for all operaions, even for increment()
  --> We can make an extra array called inc[]. if we want to increment bottom k elements, we store this operation by doing inc[k-1] += val.
  --> inc[i] = x means we need to add x to all stack elements from index 0 to i.
  --> The push operation is same as normal push operation.
  --> In case of pop operation, we add the increment value for the top element and we shift the current index's increment val to its previous index.
      Also reset the current index's increment value to 0
*/
class CustomStack {
    int[] inc,stack;
    int last;
    public CustomStack(int maxSize) {
        inc = new int[maxSize];
        stack = new int[maxSize];
        last = -1;
    }
    
    public void push(int x) {
        if(last+1<inc.length)
            stack[++last] = x;
    }
    
    public int pop() {
        if(last<0)return -1;
        int currInc = inc[last];
        if(last>0)inc[last-1] +=currInc;    // shift contribution of current index to previous index
        inc[last] = 0;  // after poping, reset the increment for that index.
        return currInc + stack[last--];
    }
    // if inc[i] = x, then we need to increment values in stack[0,1,...i] by x
    public void increment(int k, int val) {
        if(last==-1)return;
        inc[Math.min(last,k-1)]+=val;
    }
}
