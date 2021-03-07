// time and space complexity : O(N).
// upon observation we can that for numbers from 8 to 15 , we can get answer for number 0 to 7 and add 1 to it respectively.
// similar observation can be made btw numbers 4 to 7 and 2 to 3 and so on.
class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        if(num==0)return ans;
        ans[1] = 1;
        int start = 1;
        int curr = 2;
        while(curr<=num){
            start = 2*start;
            int end = 2*start - 1;
            while(curr<=end && curr<=num){
                 ans[curr] = ans[curr - start] + 1;
                 curr++;
            }
        }
        return ans;
    }
}
