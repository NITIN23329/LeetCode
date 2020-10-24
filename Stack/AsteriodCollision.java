//time O(n) and space O(n)
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> dq = new ArrayDeque<>();
        for(int ele : asteroids){
            if(helpr(dq,ele))continue;
            while(!helpr(dq,ele))dq.pop();
        }
        int[] res = new int[dq.size()];
        for(int i=res.length-1;i>=0;i--)res[i] = dq.pop();
        return res;
    }
    //if helpr return true then current case is handeled else not handled
    private boolean helpr( Deque<Integer> dq ,int ele){
        if(dq.isEmpty()){
                dq.push(ele);
                return true;
            }
            if(dq.peek()*ele>0 || (dq.peek()<0 && ele>0)){
                dq.push(ele);
                return true;
            }
            if(Math.abs(dq.peek())>Math.abs(ele))return true;
            if(Math.abs(dq.peek())==Math.abs(ele)){
                dq.pop();
               return true;
            }
        return false;
    }
}
