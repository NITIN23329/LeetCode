//time O(n^3),  creating all possible subarrays and find min in each subarray.
// we are creating subarrays from start to end.
// first we will create subarray from start to end , then start+1 to end , start+2 to end and so on.
// for each subarrays , find minimum and add it to result.
class Solution {
	public int sumSubarrayMins(int[] arr) {
		int res = 0;
		int n = arr.length;
		int mod = (int)1e9+7;
		for(int end = 0;end<n;end++){
			  for(int start = 0;start<=end;start++){
			   int min = Integer.MAX_VALUE;
				for(int i=start;i<=end;i++)
					min = Math.min(min,arr[i]);
				res = (res+min)%mod;
			}
		}
		return res;

	}
}

//optimization of above problem: time O(n^2)
//in previous solution  , we are creating subarrays from start to end.
//now we will start creating subarrays from end to start .
// we will create subarrays like end to end , end-1 to end , then end-2 to end .....start to end.In this process we are calculating min also.
//so no need to calculate min individually
class Solution {
	public int sumSubarrayMins(int[] arr) {
		int res = 0;
		int n = arr.length;
		int mod = (int)1e9+7;
		for(int end = 0;end<n;end++){
			 int min = arr[end];
			  for(int start = end;start>=0;start--){
				min = Math.min(min,arr[start]);
				res = (res+min)%mod;
			}
		}
		return res;

	}
}
/*most optimised solution: time O(n)
* for each element do :
1) use a stack to find no. of elements in between current element and smaller element(than current) on both left and right side. (Save them in array)
2) after finding above numbers , we will find number of subrrays for which current element is minimum (no of elements on left*no of elements on right).
3) after finding no. of such subrrays multiply  it with value of current element to get sum of minimum of all subarrays with current element as its minimum.
Note: In case of repetitive values, consider them only at one side. example [3,2,5,2]. 
	For 2 at index 1, leftCount[1] = 2 and rightCount[1] = 4. and for leftCount[3] = 2 and rightCount[3] = 1
	So we are gonna pop them only at one side otherwise we will create duplicate subarray.
 */
class Solution {
	public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long[] leftCount = new long[n];
        long[] rightCount = new long[n];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && arr[dq.peek()] >= arr[i])dq.pop();	// pop same elements
            leftCount[i] = dq.isEmpty()?i+1: i - dq.peek();
            dq.push(i);
        }
        dq.clear();
        for(int i=n-1;i>=0;i--){
            while(!dq.isEmpty() && arr[dq.peek()] > arr[i])dq.pop();	// don't pop same elements
            rightCount[i] = dq.isEmpty()?n-i:dq.peek() - i;
            dq.push(i);
        }
        long ans = 0;
        int mod = (int)1e9+7;
        for(int i=0;i<n;i++){
            ans += (leftCount[i]*rightCount[i]*arr[i]);
            ans %=mod;
        }
        return (int)ans;
    }
}
