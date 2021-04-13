// time complexity : O(nlogn). Space complexity : O(1)
/*
    --> Approach : Sort all intervals on basis of increasing order of start time, if they have same start time , sort the decreasing order of end time.
    --> We sort in increasing order of start time so that intervals covered by other intervals will present after the interval which cover it.
    --> We will keep hold of start and end point of some previous interval. Let say it previous start and time time
    --> If current start and end is inside the global start and end, then previous interval is covered.
    --> Otherwise the only possibility left is current end > previous end. Why? (because sorting ensures current start ? previous start)
        --> In that case we will update our previous start and end to current start and end and goto next interval.
*/
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[0]==b[0]?b[1]-a[1]:a[0]-b[0]));
        int covered = 0;
        int end = intervals[0][1];
        int start = intervals[0][0];
        int n = intervals.length;
        for(int i=1;i<n;i++){
            if(start<=intervals[i][0] && end>=intervals[i][1])covered++;
            else {
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        return n - covered;
    }
}
