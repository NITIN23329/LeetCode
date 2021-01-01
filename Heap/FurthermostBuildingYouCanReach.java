//wrost case time complexity O(2^n) which can be improved using dp
/*  approach :
      --> make tree diagram and see for a possible combinations
      --> if arr[i+1]>=arr[i]. goto next i
      --> else we have 2 choices: either use ladder or bricks
        --> if ladder >0 , use ladder and goto i
        --> if sufficient bricks are present use bricks
*/
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        return helpr(heights,bricks,ladders,0);
    }
    private int helpr(int[] height,int bricks,int ladders,int i){
        if(i==height.length-1)return i;
        if(height[i]>=height[i+1])
            return helpr(height,bricks,ladders,i+1);
        int x =-1,y=-1;
        if(ladders>0)
            x = helpr(height,bricks,ladders-1,i+1);;
        if(height[i+1]-height[i]<=bricks)
            y = helpr(height,bricks-(height[i+1]-height[i]),ladders,i+1);
        if(x==-1 && y==-1)return i;
        return Math.max(x,y);
    }
}
