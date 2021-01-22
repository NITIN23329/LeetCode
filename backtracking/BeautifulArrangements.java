// time took : 150ms
/*
  approach 1 :
      --> use brute force and find all possible arrangements for current index
      --> recursively call for next index for each possible above combination.
      --> do not use a number more than once , this can be acheived by making a boolean array of used values
      --> stop when we reached at index n+1
*/
class Solution {
    public int countArrangement(int n) {
        return dfs(1,n,new boolean[n+1]);
    }
    private int dfs(int ind, int n,boolean[] isUsed){
        if(ind==n+1)return 1;
        int c = 0;
        for(int val=1;val<=n;val++)
            if((val%ind==0 || ind%val==0) && !isUsed[val]){
                boolean[] newIsUsed = new boolean[isUsed.length];
                for(int i=0;i<newIsUsed.length;i++)
                    if(isUsed[i] || i==val)newIsUsed[i] = true;
                c+=dfs(ind+1,n,newIsUsed);
            }
        return c;
    }
}

// time took : 80ms
/*  approach 2 :
      --> this approach is an optimisation of above approach 1.
      --> for every valid val , we made a new boolean array and copied its content.
      --> now we will use backtracking.
      --> for every valid value(x) of current index which is not used yet,  mark the current valid value is true.
      --> recursively find all arrangemnets for all next indeces.
      --> after finding all possible answers having x in current index, marks x as not used and backtrack.
*/
class Solution {
    public int countArrangement(int n) {
        return dfs(1,n,new boolean[n+1]);
    }
    private int dfs(int ind, int n,boolean[] isUsed){
        if(ind==n+1)return 1;
        int c = 0;
        for(int val=1;val<=n;val++){
            if((val%ind==0 || ind%val==0) && !isUsed[val]){
                isUsed[val] = true;
                c+=dfs(ind+1,n,isUsed);
                isUsed[val] = false;
            }
        } 
        return c;
    }
}
