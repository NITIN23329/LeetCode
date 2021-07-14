/*
  --> Time : O(26*n!)
  --> We initally make a freq array .
  --> Then in every round, we take out an element from the freq array and backtrack.
  --> Every state except empty state is a valid answer.
*/
class Solution {
    public int numTilePossibilities(String tiles) {
        int[] arr = new int[26];
        for(char c : tiles.toCharArray())arr[c-'A']++;
        return find(arr)-1;
    }
    private int find(int[] arr){
        int ans = 1;  // current state is a valid answer.
        for(int i=0;i<26;i++){
            if(arr[i]>0){
                arr[i]--; // take out ith character once.
                ans+=find(arr);
                arr[i]++;
            }
        }
        return ans;
    }
}
