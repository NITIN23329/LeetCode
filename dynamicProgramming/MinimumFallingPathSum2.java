// time and space complexity : O(n*n), however space complexity can be reduced to O(n) as we will call helper() on 2 column indeces only.
// One thing to observe is that we are asked to choose any column index except  previously taken column index for every row.
// And we will somehow try to choose that column index whose element in minimum (Greedy ?). 
// There are 2 possibilities,colmun index of  current row min element  is same as colmun index of previous row min element  or not.
// If previous and current row min element's column index is same, then the only choice left for us it to consider 2nd min element in current row.
// Otherwise we will take current row min element.
// Hence we will switch btw 1st min element and 2nd min element for a particular row.
// We will do some preprocessing to find  1st and 2nd min element and their respective index and store it in minCol[].
// Then for a paritcular row, we can either choose 1st min element or 2nd min element depending upon previously chosen column index and consider minimum of both choices.
class Solution {
	public int minFallingPathSum(int[][] arr) {
		int n = arr.length;
		int[][] minCol = findMin(arr,n);    // pre-processing.
		int[][] dp = new int[n][n+1];
		for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
		return helper(arr,0,n,n,minCol,dp);
	}
	private int helper(int[][] arr,int row,int prevCol,int n,int[][] minCol,int[][] dp){
		if(row==n)return 0;
		if(dp[row][prevCol]!=-1)return dp[row][prevCol];
		int min = minCol[row][0], minIndex = minCol[row][1];
		int nextMin = minCol[row][2], nextMinIndex = minCol[row][3];
		int ans = Integer.MAX_VALUE;
		if(minIndex!=prevCol)
			ans = Math.min(ans,min + helper(arr,row+1,minIndex,n,minCol,dp));
		if(nextMinIndex!=prevCol)
			ans = Math.min(ans, nextMin + helper(arr,row+1,nextMinIndex,n,minCol,dp));
		return dp[row][prevCol] = ans;
	}
	// processing : finding 1st and 2nd minimum element value and their respective index for every row.
	private int[][] findMin(int[][] arr,int n){
		// minCol[i] = { 1st minimum element, index  of 1st minimum element, 2nd minimum element, index of 2nd minimum element} of row i.
		int[][] minCol = new int[n][4];
		for(int i=0;i<n;i++){
			int min = 100;
			int minIndex = -1;
			for(int j=0;j<n;j++)
				if(min>arr[i][j]){
					min = arr[i][j];
					minIndex = j;
				}
			minCol[i][0] = min;
			minCol[i][1] = minIndex;
			int nextMin = 100;
			int nextMinIndex = -1;
			for(int j=0;j<n;j++)
				if(j!=minIndex && nextMin>arr[i][j]){
					nextMin = arr[i][j];
					nextMinIndex = j;
				}
			minCol[i][2] = nextMin;
			minCol[i][3] = nextMinIndex;
		}
		return minCol;
	}
}
