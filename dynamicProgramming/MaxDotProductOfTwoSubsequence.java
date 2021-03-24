// time and space complexity : O(nm)
/*  approach : varitation of LCS
    --> suppose we are at i in nums1 and j in nums2, we have 4 choices in total.
    --> we consider i and j and goto f(i+1,j+1). Again we can take value of f(i+1,j+1) or not. 
        -->why? because we are asked to do atleast 1 dot product which we did my doing nums1[i]* nums2[j]. Now if f(i+1,j+1)<0 wer ignore it.
    --> we do not consider i and goto f(i+1,j)
    --> we do not consider j and goto f(i,j+1).
    --> One thing to remember is that if any array goes out of bound we return -INF as we did n't did any dot product.
*/
class Solution {
    int neginf = -(int)1e6;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n][m];
        boolean[][] isCalc = new boolean[n][m];
        int dot =  helper(nums1,nums2,0,0,dp,isCalc);
        return dot;
    }
    private int helper(int[] nums1,int[] nums2,int i,int j,int[][] dp,boolean[][] isCalc){
        if(i==nums1.length || j==nums2.length)return neginf;
        if(isCalc[i][j])return dp[i][j];
        int c1 = nums1[i]*nums2[j] + Math.max(0,helper(nums1,nums2,i+1,j+1,dp,isCalc));
        int c2 = helper(nums1,nums2,i+1,j,dp,isCalc);
        int c3 =  helper(nums1,nums2,i,j+1,dp,isCalc);
        isCalc[i][j] = true;
        return dp[i][j] = Math.max(c1,Math.max(c2,c3));
    }
}
