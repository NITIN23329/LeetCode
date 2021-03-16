// recursive code
/*  approach :
      --> same as of knap sack,
      --> for digit = 1 to 9,
        --> if cost[digit] <= target , we can consider current digit and try to create string with target-cost[digit]
        --> we can skip digit and goto next digit.
        --> out of all possible string , we take that string whose value is large.
*/
class Solution {
    public String largestNumber(int[] cost, int target) {
        String str =  recursiveHelper(cost,target);
        return str.length()==0? "0" : str;
    }
    private String recursiveHelper(int[] cost,int target){
        if(target==0)return "";
        String str = "0";
        for(int i=0;i<9;i++){
            if(target>=cost[i]){
                String next = recursiveHelper(cost,target-cost[i]);
                if(next!="0")str = max(str,(i+1)+next);
            }  
        }
        return str;
    }
    private String max(String a,String b){
        if(a.length()>b.length())return a;
        else if(a.length()<b.length())return b;
        if(a.compareTo(b)>=1)return a;
        return b;
    }
}
// time complexity : O(target^2) , space complexity : O(target)
// memoization of above recursive code.
// O(target) time took for string concatenation and string comparision
class Solution {
    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target+1];
        Arrays.fill(dp,"");
        return memoHelper(cost,target,dp);
    }
    private String memoHelper(int[] cost,int target,String[] dp){
        if(target==0)return "";
        if(dp[target].length()!=0)return dp[target];
        String str = "0";
        for(int i=0;i<9;i++){
            if(target>=cost[i]){
                String next = memoHelper(cost,target-cost[i],dp);
                if(next!="0")str = max(str,(i+1)+next);
            }  
        }
        return dp[target] = str;
    }
    private String max(String a,String b){
        if(a.length()>b.length())return a;
        else if(a.length()<b.length())return b;
        if(a.compareTo(b)>=1)return a;
        return b;
    }
}
