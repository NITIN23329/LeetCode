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
2) after find numbers , we will find number of subrrays for which current element is minimum (no of elements on left+*no of elements on right).
3) after finding no. of such subrrays multiply  it with value of current element to get sum of minimum of all subarrays with current element as its minimum.
Note: I know this solution is not intuitive...I also didn't think of this solution on first place.I came up with O(n^2) solution,
      then I took hints from youtube videos. (Not the code but some thinking).So its fine if you aren't able to solve this problem in first go. 
      If  you still not able to get it , dry run below code and you will able to it.
 */
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] leftMin = new int[n]; //store no.  elements between current element and left smaller element.
        int[] rightMin = new int[n];//store no.  elements between current element and right smaller element.
        int mod = (int)1e9+7;
        Deque<Integer> ind = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!ind.isEmpty() && arr[ind.peek()]>arr[i])
                ind.pop();
            leftMin[i] = ind.isEmpty()? i+1:i-ind.peek();
            ind.push(i);
        }
        ind = new ArrayDeque<>();
        for(int i = n-1;i>=0;i--){
            while(!ind.isEmpty() && arr[ind.peek()]>=arr[i])
                ind.pop();
            rightMin[i] = ind.isEmpty()? n-i : ind.peek()-i;
            ind.push(i);
        }
        int res = 0;
        for(int i=0;i<n;i++)
            res = (res+arr[i]*leftMin[i]*rightMin[i])%mod;    //finding sum of minimum of all possible subarrays with current element as minimum.
        return res;
        
    }
}
