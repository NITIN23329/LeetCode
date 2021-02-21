/*
    approach : ( Here we are asked to check if alex wins , not to maximize her # of stones)
        --> as the sum is odd , there is no tie.
        --> so one of them will always have odd sum and other have even sum
        --> as alex pick first , she can always make lee to pick odd indeces piles by picking even indeces piles herself
        --> similary , she can pick all odd indeces piles and lee will pick even indeces piles
        --> let say alex has sum s1 and lee has sum s2
        --> as s1 + s2 = total sum = odd, => s1 !=s2 => odd indeces sum and  even indeces sum is diff
        --> so if even indeces sum is larger she will pick all even indeces piles
        --> if odd indeced sum is larger, she will pick all odd indeces piles
        --> either way she wins.
*/
// time and space complexity : O(1)
public boolean stoneGame(int[] piles) {
        return true;
    }
// here is the dp version which finds the maximum sum alex can get if both play optimally
// time and space complexity : O(n^2)
class Solution {
    public boolean stoneGame(int[] piles) {
        int sum = 0;
        for(int ele : piles)sum+=ele;
        int n = piles.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
        int alex = recursiveHelper(piles,0,n-1,dp);
        int lee = sum - alex;
        return alex>lee;
    }
    private int recursiveHelper(int[] arr,int l,int r,int[][] dp){
        if(l>r)return 0;
        if(dp[l][r]!=-1)return dp[l][r];
        int left = arr[l] + Math.min(arr[l+1]+recursiveHelper(arr,l+2,r,dp),
                                arr[r-1]+recursiveHelper(arr,l+1,r-1,dp));
        int right = arr[r] + Math.min(arr[r-1]+ recursiveHelper(arr,l,r-2,dp),
                                arr[l]+recursiveHelper(arr,l+1,r-1,dp));
        return dp[l][r] =  Math.max(left,right);
    }
}
