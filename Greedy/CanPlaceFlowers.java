// time and space complexity : O(1)
/*
  --> Suppose we are at index i, and flowerbed[i]==1, next possible spot will be i+2.
  --> if flowerbed[i]==0, next possible spot is i+2.
  --> if flowerbed[i]==0 && flowerbed[i-1]==0 && and flowerbed[i+1]==0, then only we can plant a flower at spot i . (check for corner cases like i==0 or i==m-1)
  --> else goto next spot.
*/
class Solution {
   public boolean canPlaceFlowers(int[] flowerbed, int n) {
       int m = flowerbed.length;
       return (m==1?(flowerbed[0]==0?1:0) : helper(flowerbed,0,m)) >=n;
    }
    private int helper(int[] flower,int i,int m){
        if(i>=m)return 0;
        if(flower[i]==1)return helper(flower,i+2,m);
        if((i==0 && flower[i+1]!=1)  || (i==m-1 && flower[i-1]!=1) 
           || (i-1>=0 && i+1<m && flower[i+1]!=1 && flower[i-1]!=1))
            return 1 + helper(flower,i+2,m);
        return helper(flower,i+1,m);
    }
}
