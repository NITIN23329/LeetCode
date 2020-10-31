//time O(n) , space O(n)
/*approach: for every i :
1)find next lower element's index and previous lower element's index
2) calculate no. of elements having height>= height[i]: ( (i-previous lower index) + ( next lower index - i-1) ) = x
Note : I did -1 extra cuz current elements chould not be counted 2 times.
3)find total area = height[i]*x
4) find maximum area
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nextLower = new int[n];
        int[] prevLower = new int[n];
        Deque<Integer> ind = new ArrayDeque<>();
       for(int i=0;i<n;i++){
            while(!ind.isEmpty() && heights[ind.peek()]>=heights[i])
                ind.pop();
            prevLower[i] = ind.isEmpty() ? i+1 : i-ind.peek();
            ind.push(i);
        }
        ind = new ArrayDeque<>();
        for(int i=n-1;i>=0;i--){
            while(!ind.isEmpty() && heights[ind.peek()]>=heights[i])
                ind.pop();
            nextLower[i] = ind.isEmpty()? n-i-1 : ind.peek()-i-1; 
              ind.push(i);
        }
        int res = 0;
        for(int i=0;i<n;i++)
            res = Math.max(res ,(nextLower[i]+prevLower[i])*heights[i]);
        return res;
    }
}
