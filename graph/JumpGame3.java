// time O(n) , space O(n)
// approach : at index 'i', recursive call for arr[i+arr[i]] and arr[i-arr[i]]
// make all visited element =-1 so that we can not traverse again
class Solution {
    public boolean canReach(int[] arr, int start) {
        if(arr[start]==0)return true;
        if(arr[start]==-1)return false;
        int x = arr[start];
        arr[start] = -1;
        boolean ans = false;
        if(start+x<arr.length)
            ans = ans | canReach(arr,start+x);
        if(start-x>=0)
            ans = ans | canReach(arr,start-x);
        return ans;
    }
}
