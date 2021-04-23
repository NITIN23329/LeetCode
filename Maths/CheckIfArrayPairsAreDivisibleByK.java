// time complexity : O(n), space complexity : O(1)
/*
    approach :
      --> Intuition : suppose we have a pair(a,b). now this pair sum is divisible by k only if a%k + b%k = 0 or k.
      --> proof : let say, a%k == c then b%k = k - c or  -c. Since remainer can not be <0, we discard later case.
          --> if b%k = k-c, then a = xk + c and b = yk + k - c, => a+b = xk + c + yk + k - c = (x+y+1)*k which is divisible by k.
     --> So for every number which given a remainder c when divided by k, we need another number which gives a remainder k-c when divided by k.
     --> one corner case is if a%k==0,then b%k should be 0. So we must have even # of elements whose remainder gives 0 when divided by k.
*/
class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] remainderCount = new int[k];
        for(int ele : arr)
            if(ele<0){
                if(-ele%k==0)remainderCount[0]++;
                else remainderCount[k - (-ele%k)]++;
            }
            else remainderCount[ele%k]++;
        if(remainderCount[0]%2==1)return false;
        int i = 1;
        int j = k-1;
        while(i<=j){
            if(remainderCount[i]!=remainderCount[j])
                return false;
            i++;j--;
        }
        return true;
    }
}
