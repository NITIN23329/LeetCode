/*
        approach : MCM format
                --> for every k in [1...n] , we will take k as root node
                --> recursive find the total # of ways to create left subtree[1,k-1] and right subtree [k+1,n]
                --> we will multiply leftCount and rightCount to get # of BST having k as root node
                --> we fill add ans for every k and return it as answer
                --> base case l>r returns 1 as when k==l , left subtree's {l,r} = {l,k-1} = {l,l-1},in that case left subtree is null so return 1
     */
    public int recursive(int N){
        return recursiveHelper(1,N);
    }
    private  int recursiveHelper(int l,int r){
        if(l>r)return 1;
        int ans = 0;
        for(int k=l;k<=r;k++){
            int leftCount = recursiveHelper(l,k-1);
            int rightCount = recursiveHelper(k+1,r);
            ans += (leftCount*rightCount);
        }
        return ans;
    }
    // time complexity O(n^3) and space complexity O(n^2)
    // memoization of above recursive code
    public int memoization(int N) {
        int[][] dp = new int[N+1][N+1];
        for(int i=0;i<=N;i++) Arrays.fill(dp[i],-1);
        return memoHelper(1,N,dp);
    }
    private  int memoHelper(int l,int r,int[][] dp){
        if(l>r)return 1;
        if(dp[l][r]!=-1)return dp[l][r];
        int ans = 0;
        for(int k=l;k<=r;k++){
            int leftCount = memoHelper(l,k-1,dp);
            int rightCount = memoHelper(k+1,r,dp);
            ans  += (leftCount*rightCount);
        }
        return dp[l][r] = ans;
    }
    // time complexity O(n^2) and space complexity O(n)
    // we can see from previous solution that value of l and r doest not matter
    // what matters if range of {l,r}. i.e. ans of [10,20]  = ans of [15,25]
    public int numTrees(int N) {
        int[] dp = new int[N+1];
        Arrays.fill(dp,-1);
        return memoHelper(N,dp);
    }
    private  int memoHelper(int n,int[] dp){
        if(n<=0)return 1;
        if(dp[n]!=-1)return dp[n];
        int ans = 0;
        for(int k=1;k<=n;k++){
            int leftCount = memoHelper(k-1,dp);
            int rightCount = memoHelper(n-k,dp);
            ans  += (leftCount*rightCount);
        }
        return dp[n] = ans;
    }
