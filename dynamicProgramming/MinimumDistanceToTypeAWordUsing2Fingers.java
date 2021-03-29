// time and space complexity : O(n * 27 *27)
/*
  1)Assuming the position as a 2D grid would lead to much higher dimensions dp table.
  2)Instead we will mark code for each character, Like 'A' -> 1, 'B' -> 2 , 'G' -> 7 .... 'Z' -> 26
  3)So instead of having x and y corrdinates for each finger, we will represents each finger by these codes.
  4)In a HashMap, we store the code for each character and its respective position in 2D grid for calculating distance btw 2 consecutive characters of word .
  5) After this, finger1 and finger2 have value in range [0,26] denoting previously typed character by them. finger2==0 means finger 2 has not been used yet.
  6) If finger2 has not been used yet, we have 2 options, either to start using finger2 or we use of finger1 to type current character.
  7) When both fingers are used previously, we have 2 choices either to use finger1 to type current character or use finger 2
  
*/
class Solution {
    Map<Integer,int[]> map;
    int[][][] dp;
    public int minimumDistance(String str) {
        map = new HashMap<>();
        for(int i=0;i<5;i++)
            for(int j=0;j<6;j++)
                map.put(i*6+j+1,new int[]{i,j});
        dp = new int[str.length()][27][27];
        for(int i=0;i<dp.length;i++)
            for(int j=0;j<27;j++)
                Arrays.fill(dp[i][j],-1);
        return helper(str,1,str.charAt(0)-'A'+ 1,0);
        
    }
    private int helper(String str,int i,int finger1,int finger2){
        if(i==str.length())return 0;
        if(dp[i][finger1][finger2]!=-1)return dp[i][finger1][finger2];
        int ch = str.charAt(i) - 'A' + 1;
        if(finger2==0){
            int c1 = helper(str,i+1,finger1,ch);    // start using finger 2
            int c2 = distance(map.get(ch),map.get(finger1)) + helper(str,i+1,ch,finger2);   // finger 1 is used
            return  dp[i][finger1][finger2] = Math.min(c1,c2);
        }
        int c1 = distance(map.get(ch),map.get(finger1)) + helper(str,i+1,ch,finger2);   // finger 1 is used
        int c2 = distance(map.get(ch),map.get(finger2)) + helper(str,i+1,finger1,ch);    // finger 2 is used
        return  dp[i][finger1][finger2] = Math.min(c1,c2);
    }
    private int distance(int[] a,int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
