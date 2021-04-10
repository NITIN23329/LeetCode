// time complexity : O(n) and space complexity : o(1)
/*
  approach :
  --> suppose we are at index i having x # of 1's to right of it and having a current rightSum(denotes # of operations to move all 1's on right of it to index i).
  --> if we goto i+1 and boxes[i+1]==0, then for i+1'th rightSum = i'th rightSum - x. Cuz now all ones on right of it moves closer to i+1th index by 1.
  --> Similarly let y # of 1's are left to index i having leftSum(denotes # of operations to move all 1's on left of i to index i).
  --> if we goto i+1 and boxes[i] = 0, the. for i+1th leftSum = i'th leftSum + y. Cuz now all ones on left of it moves farther to i+1th index by 1.
  --> We create a suffix array rightOneCount[i] which denotes # of 1's on right of index i. We can create leftOneCount[] also but we can get it with the help of rightOneCount[].
  --> On moving from i to i+1th index, if there is a change in rightOneCount, it means our rightOneCount decreases by one, so reduce rightSum by 1.
  --> On moving from i to i+1th index, if there is a change is leftOneCount, it means leftOneCount increases by one, so increase leftSum by 1.
*/
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] rightOneCount = new int[n];   // tells # of ones on right of index i.
        int oneCount = 0;
        int rightSum = 0;
        int leftSum = 0;
        for(int i=n-1;i>=0;i--){
            rightOneCount[i] = oneCount;
            if(boxes.charAt(i)=='1'){
                oneCount ++;
                rightSum +=i;
            }
        }
        int[] ans = new int[n];
        ans[0] = rightSum;  // no leftSum for index 0.
        for(int i=1;i<n;i++){
            // leftOneCount[i] = currLeftOneCount
            int currLeftOneCount = oneCount - rightOneCount[i-1];
            // leftOneCount[i-1] = prevLeftOneCount
            int prevLeftOneCount = i==1? 0: oneCount - rightOneCount[i-2];
            //On moving from i to i+1th index, if there is a change is leftOneCount, it means leftOneCount increases by one, so increase leftSum by 1.
            if(currLeftOneCount!=prevLeftOneCount)leftSum++;
            // On moving from i to i+1th index, if there is a change in rightOneCount, it means our rightOneCount decreases by one, so reduce rightSum by 1.
            if(rightOneCount[i]!=rightOneCount[i-1])rightSum--;
            //if we goto i+1 and boxes[i+1]==0, then for i+1'th rightSum = i'th rightSum - x. Cuz now all ones on right of it moves closer to i+1th index by 1.
            rightSum -= rightOneCount[i];
            // if we goto i+1 and boxes[i] = 0, the. for i+1th leftSum = i'th leftSum + y. Cuz now all ones on left of it moves farther to i+1th index by 1.
            leftSum += prevLeftOneCount;
            ans[i] = rightSum + leftSum;
        }
        return ans;
    }
}
