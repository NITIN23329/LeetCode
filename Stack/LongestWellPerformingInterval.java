//time : O(n^2) , consider all contigious subarray
class Solution {
    public int longestWPI(int[] hours) {
        int res = 0;
        int curr = 0;
        for(int start = 0 ; start<hours.length;start++){
            curr = 0;
            for(int end = start ; end<hours.length;end++){
                if(hours[end]>8)curr++;
                else curr--;
                if(curr>0)res = Math.max(res , end-start+1);
            }
        }
        return res;
    }
}
