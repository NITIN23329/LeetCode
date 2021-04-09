// time complexity : O(nlogn), space complexity O(1)
/*
  --> Approach :
  --> If there are some negative elements and # of negative elements > k, then we can make some of them positive.
  --> But to get more sum, we will negate smallest k negative numbers.(-4,-2,-1) and k=2, we will negate -4 and -2.
  --> if we have  some negative left, it means k is reduced to zero. If we have some k left, it means all numbers are now positive.
  --> If k == 0, we can not do anything hence return sum.
  --> If some k is left, we will repetively negative the minimum positive element, if k%2==0, it remains positive else it becomes negative.
*/
class Solution {
    public int largestSumAfterKNegations(int[] arr, int k) {
        Arrays.sort(arr);
        int i=0;
        while(i<arr.length && k>0){
            if(arr[i]>=0)break;
            if(arr[i]<0){
                arr[i] = -arr[i];
                k--;
            }
            i++;
        }
        int minPos = Integer.MAX_VALUE;
        for(int ele : arr)if(ele>=0)minPos = Math.min(minPos,ele);
        int sum = 0;
        for(int ele : arr)sum+=ele;
        return k%2==0? sum : sum - 2 * minPos;
    }
}
