// time complexity : O(logn)
/*
    --> As n is pretty high upto 10^9, this may give an idea to use binary search maybe..
    --> How to apply bs?.Well we need to find maximum value to put in arr[index]. We can use bs to find maximim value we can put on index.
    --> We can assume a value for our arr[index] and check whether it is possible to get total sum of array <= maxSum.
    --> If so, then we we can put value in arr[index].
    --> Now we need to maximize it, so we try use bs to check if value + 1 is possible or not. If not , value is the maximum possible answer for arr[index]
    --> If value+1 is possible then we move to right half of our search space, else left half.
    --> But the hard thing is how to check if arr[index] = value is possible or not?
    --> Left part and right part of index can be solved independently of each other. Why? (See it yourself)
    --> Put arr[index] = value and see what values left of index have? may be 1,2,3,....value.
    --> Remember we need min sum of arr[0.....index-1] so that arr[index] max be maximized.
    --> So find the minimum possbible sum of arr[0.....index-1](the left part of index).
        --> There are 2 cases, Firstly if we have sufficient places to put 1,2,....arr[index] on left part. (index>=arr[index]-1)
            --> So we put arr[index]-1,arr[index-2]...3,2,1(reverse it) and for rest places we put 1 on it so we get min left sum.
        --> Secondly, we dont have enough space to put 1,2,....arr[index] on left part. (index<arr[index]-1)
            -->Only choice to put is arr[index]-1,arr[indedx]-2....(reverse it) untill we have places.
    --> Similarly we can use same algorithm to find minimum possible right sum .
    --> minLeftSum + minRightSum + value <= maxSum, then only we can put arr[index] = value.
    
*/
class Solution {
    public int maxValue(int n, int index, int maxSum) {
        return (int)bs(1,maxSum,index,maxSum,n);
    }
    private long bs(long l,long r,int index,int maxSum,int n){
        if(l>r)return -1;
        long mid = (r-l)/2 + l;
        boolean curr = isPossible(index,mid,n,maxSum);
        boolean next = isPossible(index,mid+1,n,maxSum);
        if(curr && !next)return mid;
        if(curr && next)return bs(mid+1,r,index,maxSum,n);
        return bs(l,mid-1,index,maxSum,n);
    }
    private boolean isPossible(int index,long mid,int n,int maxSum){
        long minLeftSum = calcMinSum(index,mid);
        long minRightSum =calcMinSum(n-index-1,mid);
        long totalSum = minLeftSum+minRightSum+mid;
        if(totalSum<=maxSum)return true;
        return false;
    }
    private long calcMinSum(int index,long mid){
        if(index>=mid-1)return (mid*(mid-1))/2 + (index - (mid-1));
        return (mid*(mid-1))/2 - (mid-index)*(mid-index-1)/2;
    }
}
