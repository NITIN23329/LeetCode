// time complexity O(3^n) loose bound
/*  approach : 
      --> for a current day, we have 3 choices, either to be Present or Absent or Late
      --> we consider all 3 choices, so we took variable : abs to reprsent total # of absent days and cons_late to represent # of consecutive late days.
      --> if at any point, our absent day exceeds 1  or if our consecutive late days exceed 2, we return 0.
      --> if current day is present, consecutive late days comes back to 0, but total # of absent day remains same
      --> if current day is absent, consecutive late days comes back to 0, but total # of absent day increases by 1
      --> if current day is late day,  consecutive late daysincreases by 1 , but total # of absent day remains same
*/
class Solution {
    int mod = (int)1e9+7;
    public int checkRecord(int n) {
        return (int)recursiveHelper(0,n,0,0);
    }
    private long recursiveHelper(int day,int n, int abs,int cons_late){
        if(abs>1 || cons_late>2)return 0L;
        if(day==n)return 1L;
        long ans = 0L;
        ans = (ans + recursiveHelper(day+1,n,abs,0))%mod;                // present case
        ans = (ans + recursiveHelper(day+1,n,abs+1,0))%mod;             // absent case
        ans = (ans + recursiveHelper(day+1,n,abs,cons_late+1))%mod;    // late case
        return ans;
    }
}
// memoization of above recursive code, time and space complexity : O(6n)
class Solution {
    int mod = (int)1e9+7;
    public int checkRecord(int n) {
        long[][][] dp = new long[n][2][3];
        for(int i=0;i<n;i++)
            dp[i] = new long[][]{{-1,-1,-1},{-1,-1,-1}};
        return (int)memoHelper(0,n,0,0,dp);
    }
    private long memoHelper(int day,int n, int abs,int cons_late,long[][][] dp){
        if(abs>1 || cons_late>2)return 0L;
        if(day==n)return 1L;
        if(dp[day][abs][cons_late]!=-1)return dp[day][abs][cons_late];
        long ans = 0L;
        ans = (ans + memoHelper(day+1,n,abs,0,dp))%mod;                // present case
        ans = (ans + memoHelper(day+1,n,abs+1,0,dp))%mod;             // absent case
        ans = (ans + memoHelper(day+1,n,abs,cons_late+1,dp))%mod;    // late case
        return dp[day][abs][cons_late] = ans;
    }
}
