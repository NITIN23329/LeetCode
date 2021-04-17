// time complexity : O(nlogn), space complexity : o(n)
/*
  --> The approach is to club all overlaping ballons and brust them in one go.
  --> So we can sort each balloon in increasing order of end time first.
  --> Then let say currEnd hold of the current balloon's ending point.
  --> Then each ballon next to it having starting point <= currEnd can be brust along with the current ballon.
  --> if a next balloon's start > currEnd, then no overlaping is there then we update our currEnd and continue doing above.
  --> Consider a case [[5,10],[8,10],[12,18],[10,20]]. We can brust 1st , 2nd and 4th balloon in one go but our our algorithm dont do that.
  --> Well if a right ballon can be burst along 1st and 2nd ballon, it means start of 4th <= end of 1st and 2nd. 
  --> And 3rd end > 1st and 2nd start(due to sorting), so start of 4th <= end of 3rd always hold and 4th balloon can be burst with 3rd ballon
*/
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->(Integer.compare(a[1],b[1])));
        int currEnd = points[0][1];
        int i = 1;
        int count = 0;
        while(i<points.length){
            if(points[i][0]>currEnd){
                count++;
                currEnd = points[i][1];
            }
            i++;
        }
        count++;
        return count;
    }
}
