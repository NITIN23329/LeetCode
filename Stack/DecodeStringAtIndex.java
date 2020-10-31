//TLE solution
class Solution {
    public String decodeAtIndex(String s, int k) {
        Deque<Integer[]> dq = new ArrayDeque<>();
        int i=-1;
        int z=0;
        while(z<k){
            z++;
            i++;
            char c = s.charAt(i);
            if(c>'0' && c<='9'){
                if(dq.isEmpty() || dq.peek()[0]!=i){
                    int x =c-48-1;
                    if(x>0){
                        dq.push(new Integer[]{i,x});
                        i=0;
                    }else z--;
                }
                else {
                    int x = dq.peek()[1]-1;
                    if(x==0){
                        dq.pop();
                        z--;
                    }
                    else {
                        dq.peek()[1]--;
                        i=0;
                    }
                }
            }
        }
        if(s.charAt(i)>'0' && s.charAt(i)<='9')i=0;
        return s.charAt(i)+"";
    }
}
