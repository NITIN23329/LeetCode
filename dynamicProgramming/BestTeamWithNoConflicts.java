// time complexity O(n^2) and space complexity O(n)
/*  
    approach : variation of LIS: let say dp[i] represents the max sum we can get by inculding payer i.
    --> for a particular player we can take all younger players with lower or equal score.
    --> so it seems that we need to sort them according to their ages.
    --> But what about same age player. Can we take all of them? Not really.
    --> Consider a case with age: [1,2,2] and score[5,7,3]. Here we for 2nd player we can take 1st player but for 3rd player we cannt take 1st player.
    --> How to handle this? Remember we are using LIS so we will use dp[j] to calculate dp[i] where j < i.
    --> let say age[i] == age[j] where i>j. There may be 2 cases score[j]>score[i] or score[j]<=score[i]. 
    --> Consider the first case , let k be a player s.t. age[k] < age[i]=age[j] and score[k]<=score[j] but score[k]>score[i]. Surely we have added player k while calculating answer for player j.
    --> Since age[i]==age[j], we will try to include answer of j which indeed contains player k. If we include player k there will be a conflict btw k and i player.
    --> Now consider 2nd case ( score[j]<=score[i] ). If we inculded some k players in j then we can include these players in i also as score[i]>=score[j].
    --> This gives the idea to sort same age playes in increasing order of their scores.
    --> So for i in range 0 to n-1 do :
          --> for player j in range 0 to i-1, we can only add them if its score is < player i score.
    --> we take maximum of all i's cuz it can be possible to take all players of age i and ignore all players of age j 
*/
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        // sort player accoring to ages then accoring to score in increasing order.
        Arrays.sort(arr,(a,b)->(a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));
        int[] dp = new int[n]; // dp[i] = {max score upto index i}
        int max = 0;
        for(int i=0;i<n;i++){
            dp[i] = arr[i][1];
            for(int j=0;j<i;j++){
                if(arr[j][1] <= arr[i][1]){
                    dp[i] = Math.max(dp[i],arr[i][1] + dp[j]);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
