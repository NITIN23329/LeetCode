// time and space complexity : O(nlogn)
/*
    --> Simply simulate the game.
    --> The work of alice is to gain maximum possible stone while bob will try to reduce the stones alice get.
    --> since our m can be go upto 2 * logn  , the time and space complexity becomes O(nlogn)
*/ 
class Solution {
     int[][] alice,bob;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int maxm = 1;
        while(maxm<n)maxm*=2;
        alice = new int[n+2][maxm+1];
        bob = new int[n+2][maxm+1];
        for(int i=0;i<n+2;i++){
            Arrays.fill(alice[i],-1);
            Arrays.fill(bob[i],-1);
        }
        return aliceHelper(piles,0,1,n);
    }
    private int aliceHelper(int[] piles,int i,int m,int n){
        if(i>=n)return 0;
        if(alice[i][m]!=-1)return alice[i][m];
        int ans = 0;
        int curr = 0;
        for(int x=i;x<i+2*m && x<n;x++){
            curr+=piles[x];
            ans = Math.max(ans,curr + bobHelper(piles,x+1,Math.max(m,x-i+1),n));
        }  
        return alice[i][m] = ans;
    }
    private int bobHelper(int[] piles,int i,int m,int n){
        if(bob[i][m]!=-1)return bob[i][m];
        int ans = Integer.MAX_VALUE;
        for(int x=i;x<i+2*m;x++){
            if(x>=n){
                ans = 0;
                break;
            }
            ans = Math.min(ans,aliceHelper(piles,x+1,Math.max(m,x-i+1),n));
        }
        return bob[i][m] = ans;
    }
}
