// time complexity : O(n), space complexity : O(1)
/*
  --> First thing to notice is that we will try to swap towards last of array if possbile.Why?(Hint: we are going to find lexicograpically smaller but closest to given array.)
  --> If we swap towards first but we have an opportunity towards last, then the first swapped is smaller that last swapped and both are smaller that given arr. 
  --> So we go from right to left in array and check of arr[i] > arr[i+1]. If we found we stop.
  --> Now we found our last swapping place. But with whome we will swap it?
  --> We will swap it with the greatest element on right of it which is smaller that itself.
  --> Note that we are pushing a greater element towards right of array by swapping it with a minimum value.
  --> If we have multiple occurences of the greatest element on right of the swapping place, then we will swap with the smallest index possible.
  --> Example arr = [ 1,2,6,4,4,4,4,10] We are going to swap 6 with a 4 . We will take the smallest possible index of 4 which is right to 6. (after swapping, arr = [ 1,2,4,6,4,4,10])
*/
class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int index = -1;
        for(int i=arr.length-2;i>=0;i--)
            if(arr[i]>arr[i+1]){
                index = i;
                break;
            }
        if(index!=-1){
            int nextMax = 0;
            int nextMaxIndex = -1;
            for(int i = index+1;i<arr.length;i++){
                if(arr[i]<arr[index] && nextMax<arr[i]){
                    nextMax = arr[i];
                    nextMaxIndex = i;
                }
            }
            int temp = arr[index];
            arr[index] = nextMax;
            arr[nextMaxIndex] = temp;
        }
        return arr;
    }
}
