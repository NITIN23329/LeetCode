// recursive code 
/*  
  recursive approach : follows MCM format
    --> for every partition k in l to r , 
    --> find cost of creation of left subtree arr[l,k] 
    --> find cost of creation of right subtree arr[k+1,r]
    --> for joining tree with above left and right subtree, cost = cost(left) + cost(right) + max(arr[l,k]) * max(arr[k+1,r])
    --> we can find max(arr[l,k]) and max(arr[k+1,r]) in O(1) otherwise we will be needing a extra loop for it.
    --> we return an array {cost of tree creation, maximum child of current tree}
    --> base case is when when we have only 1 node , we will return {0,node val}
*/
class Solution {
    public int mctFromLeafValues(int[] arr) {
        return recursiveHelper(arr,0,arr.length-1)[0];
    }
    private int[] recursiveHelper(int[] arr,int l,int r){
        if(l==r)
            return new int[]{0,arr[l]};
        int[] ans = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE};
        for(int k=l;k<r;k++){
            int[] left = recursiveHelper(arr,l,k);
            int[] right = recursiveHelper(arr,k+1,r);
            int[] curr = new int[2];
            curr[0] = left[0] + right[0] + left[1]*right[1];
            curr[1] = Math.max(left[1],right[1]);
            if(ans[0]>curr[0])ans = curr;
        }
        return ans;
    }
}
// memoization of above recursive code
// time complexity O(N^3) , space complexity : O(n^2)
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][][] dp = new int[n][n][2];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dp[i][j] = new int[]{-1,-1};
        return recursiveHelper(arr,0,n-1,dp)[0];
    }
    private int[] recursiveHelper(int[] arr,int l,int r,int[][][] dp){
        if(l==r)
            return new int[]{0,arr[l]};
        if(dp[l][r][0]!=-1)return dp[l][r];
        int[] ans = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE};
        for(int k=l;k<r;k++){
            int[] left = recursiveHelper(arr,l,k,dp);
            int[] right = recursiveHelper(arr,k+1,r,dp);
            int[] curr = new int[2];
            curr[0] = left[0] + right[0] + left[1]*right[1];
            curr[1] = Math.max(left[1],right[1]);
            if(ans[0]>curr[0])ans = curr;
        }
        return dp[l][r] = ans;
    }
}
