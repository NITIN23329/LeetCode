// time complexity : O(mlongm) and can be reduced to O(n) using map. Space complexity : O(1)
/*
    --> as n  = 10^9, amd m = 10^4, we first consider those rows having reserved seats .
    --> For a particular row, we first try to put 2 groups at (2,3,4,5) and (6,7,8,9) if possible else try to put 1 group at (4,5,6,7) if possible.
    --> So we find # of groups we can put in all reserved rows. Then for reamining rows, we can put 2 in each of them  = 2 * (n-# of reserved rows).
    --> We do sorting so that reserved seats of a particular row comes together, instead we can use map to reduce time complexity.
*/
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats,(a,b)->(a[0]-b[0]));
        int i = 0;
        int m = reservedSeats.length;
        int ans = 0;
        int calculated = 0;
        while(i<m){
            boolean[] reserve = new boolean[10];
            int j = i;
            while(j<m && reservedSeats[j][0]==reservedSeats[i][0]){
                reserve[reservedSeats[j][1]-1] = true;
                j++;
            }
            int curr = 0;
            if(!reserve[1] && !reserve[2] && !reserve[3] && !reserve[4])
                curr++;
            if(!reserve[5] && !reserve[6] && !reserve[7] && !reserve[8])
                curr++;
            if(!reserve[3] && !reserve[4] && !reserve[5] && !reserve[6] && curr==0)
                curr++;
            ans += curr;
            calculated++;
            i = j;   
        }
        return ans + 2 * (n-calculated);
    }
}
