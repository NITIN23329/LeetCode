// time O(9*n) , at most size of n = 9 
/*  approach :
     --> initially take numbers from 1,2,3...9.
     --> generate 2 new number from previous number(x). n1 = x.append(lastDigit of x + k) and n2 = x.append(lastDigit of x - k).
     --> add n1 and n2 if valid. (what if lastDigit of x +k >= 10 and lastDigit of x - k < 0?)
     --> in this way diff btw every digit place is of k.
     --> do this for n time to get all digit of length n.
     --> when k==0 , n1 and n2 are same , add only 1 of them to remove duplicacy.
    
*/
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=9;i++)q.add(i);
        while(n-->1){
            int s = q.size();
            for(int i=0;i<s;i++){
                int x = q.poll();
                int lastDigit = x%10;
                int n1 = lastDigit+k;
                int n2 = lastDigit-k;
                if(n1<10)q.add(x*10+n1);
                if(n1!=n2 && n2>=0)q.add(x*10+n2);
            }
        }
        int[] res = new int[q.size()];
        for(int i=0;i<res.length;i++)res[i] = q.poll();
        return res;
    }
}
