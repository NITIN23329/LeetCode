// time and space complexity : O(nlogn), space complexity : O(1)
/*
    --> Suppose we have a overlap btw intervals a and b s.t. end of b > end of a. Obviously remove one of them, but which one to remove to get optimal answer?
    --> Let say a = [4,10] and b = [6,20]. I claim that removing b(with high end point) would be better. Why?
    --> Firstly all point btw the overlap point :  4,5,6. If these points have another interval, we remove any 2 intervals.
    --> All remaining point of interval b : 7,8,...20, Let there is a new interval which starts from these points, say c = [10,30].
        -->  Removing b, reduces all 2 overlaps. we left with a and c with no overlaps
        -->  But instead if we remove a, we have 1 overlap btw b and c also.
   --> So it is always better to remove last end interval as it will reduce our current overlap and also 
      free spaces for next intervals hence possibly reduces some next overlaps that might happen.
   --> while removing first ending overlap will remove overlaps by 1 only.
*/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[1]-b[1]));
        int overlaps = 0;
        int prev_end = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<prev_end)overlaps++;
            else prev_end = intervals[i][1];
        }
        return overlaps;
    }
}
