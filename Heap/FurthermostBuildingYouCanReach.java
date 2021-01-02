//[TLE]wrost case time complexity O(2^n) which can be improved using dp
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
// time complexity O(nlog(ladders)) , space complexity : O(n)
/*
      --> we can take a minheap of size = ladders , we take so cuz this is guarenteed that we can pass all building in heap with all ladders
      --> out of all heights in heap , we use bricks to pass smaller heights, and ladders are remained to be used for larger heights
      --> if the size of heap overflow(ladders+1) , we poll smallest height building and pass with bricks
      --> if bricks are less in number we return i cuz all other heights in heap(size==ladders) can be passed with all ladders
      --> one corner case is when ladders=bricks=0, we return as soon as height[i]<height[i+1]
*/
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int s = Math.max(1,ladders);
        boolean isBothZero = bricks+ladders==0 ? true : false;
        for(int i=0;i<heights.length-1;i++){
            if(heights[i]<heights[i+1]){
                if(isBothZero)return i;
                pq.add(heights[i+1]-heights[i]);
                if(pq.size()>s){
                   if(pq.peek()<=bricks)
                        bricks-=pq.poll();
                   else return i;
                }
            }
        }
        return heights.length-1;
    }
}
