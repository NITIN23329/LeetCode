// time complexity : O(n) , space complexity : O(1)
/*
  --> We will use the fact that since we need n faces of same type, we must have occurence of that face >= n .
  --> We store occurence of each faces.
  --> For a faces whose occurence is >=n, That face is the only possible candidate to get an array of that face.Why?
  --> if occurence > n then that face is only face we may get , if occurence == n There may be 2 different faces possible, but our considered face is one of them.
  --> We can try to put that face either in A[] or in B[] and we can choose that array which need minimum # of swaps.
*/
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int[] freq = new int[7];
        for(var face : A)freq[face]++;
        for(var face : B)freq[face]++;
        for(var face = 1;face<=6;face++){
            if(freq[face]>=A.length){
                int swaps = Math.min(countSwaps(A,B,face),countSwaps(B,A,face));
                if(swaps<=A.length)return swaps;
                else break;
            }
        }
        return -1;
    }
    private int countSwaps(int[] main,int[] supplement,int face){
        int swaps = 0;
        for(var i=0;i<main.length;i++)
            if(main[i]!=face){
                if(supplement[i]!=face){
                    swaps = main.length+2;
                    break;
                }
                else swaps++;
            }
        return swaps;
    }
}
