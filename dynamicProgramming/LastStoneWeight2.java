/*
for three number a1, a2, a3, according to the order of our choice,
there are 8

1)  a1 - (a2 - a3) = a1 - a2 + a3
2)  (a2 - a3) - a1 = -a1 + a2 - a3
3)  a1 - (a3 - a2) = a1 + a2 - a3
4)  (a3 - a2) - a1 = -a1 - a2 + a3
5)  a2 - (a1 - a3) = -a1 + a2 + a3
6)  (a1 - a3) - a2 = a1 - a2 - a3
    a2 - (a3 - a1) = a1 + a2 - a3 same as case 3
    (a3 - a1) - a2 = -a1 - a2 + a3 same as case 4
    a3 - (a1 - a2) = -a1 + a2 + a3 same as case 5
    (a1 - a2) - a3 = a1 - a2 - a3 same as case 6
    a3 - (a2 - a1) = a1 - a2 + a3 same as case 1
    (a2 - a1) - a3 = -a1 + a2 - a3 same as case 2
for each number, we can add '+' or '-' before it. there are totally 2^3 = 8 cases
which is 6 above cases + all positive (a1+a2+a3) and all negtive(-a1-a2-a3) is clearly can not be our answer, so finally our answer lies in 6 above cases 

So this problem recduces to find all possible combiantions to put + or - before each number which can be solved using mimimum subset sum diff
we can consider 2 sets , s1 includes all numbers which are added
and s2 contains all numbers which are subtracted
s1 - s2 = ans, we want to minimize ans .
*/
// time and space complexity : O(n*sum(arr))
class Solution {
    public int lastStoneWeightII(int[] arr) {
        int sum = 0;
        for(int ele : arr)sum += ele;
        int[][] dp = new int[arr.length][3001];
        for(int i=0;i<arr.length;i++)
            Arrays.fill(dp[i],-1);
        return memoHelper(arr,0,sum,0,dp);
        
    }
    private int memoHelper(int[] arr,int i,int sum ,int curr,int[][] dp){
        if(arr.length==i)
            return Math.abs(sum-2*curr);
        if(dp[i][curr]!=-1)return dp[i][curr];
            return dp[i][curr] = Math.min(memoHelper(arr,i+1,sum,curr+arr[i],dp),
                                      memoHelper(arr,i+1,sum,curr,dp));
    }
}
