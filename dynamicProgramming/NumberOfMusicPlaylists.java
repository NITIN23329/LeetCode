// time and space complexity : O(nl)
/*
  approach : left songNumber denotes the # of songs played till now and usedSong dentoes the # of distinct songs played till now.
    --> First thing to observe is that if our songNumber < k then the only choice we have is to play a new unique song. Out of (n-usedSong) songs, we can use any.
    --> if usedSong == n then we used all our songs, now only choice left is to repeat a previously played song. But we can not choose any previous song...
    --> We need to choose a song which is not played in k recent plays or we could say we can play any of  (distintSong - k) songs.
    --> if we have songNumber >=k and usedSong<n the we can either play a new unique song or we can pick a usedSong which is not played in k recent songs.
*/
class Solution {
    int mod = (int)1e9+7;
    public int numMusicPlaylists(int n, int l, int k) {
        long[][] dp = new long[l][n+1];
        for(int i=0;i<l;i++)Arrays.fill(dp[i],-1);
        return (int)helper(0,l,0,n,k,dp);
    }
    private long helper(int songNumber,int l,int usedSong,int n,int k,long[][] dp){
        if(songNumber==l)return usedSong==n?1:0;
        if(dp[songNumber][usedSong]!=-1)return dp[songNumber][usedSong];
        long ans = 0;
        if(songNumber<k)
            ans =  (n-usedSong) * helper(songNumber+1,l,usedSong+1,n,k,dp);
        else if (usedSong==n)
            ans =  (usedSong-k) * helper(songNumber+1,l,usedSong,n,k,dp);
        else 
            ans = (n-usedSong) * helper(songNumber+1,l,usedSong+1,n,k,dp) + 
            (usedSong-k) * helper(songNumber+1,l,usedSong,n,k,dp);
        return dp[songNumber][usedSong] = ans%mod;
    }
}
