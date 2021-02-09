// time for preprocessing O(n) and time for sumRange is O(1)
// space complexity O(n)
// we calcuklate prefix sum and store in an array
// for given i,j , prefixSum[i] = sum(0,i) and prefixSum[j] = sum(0,j)
// So prefixSum[j] - prefixSum[i-1] = sum(0,j) - sum(0,i-1) = sum(i,j)
class NumArray {
    private int[] prefixSum;
    public NumArray(int[] nums) {
        // it will store prefix sum
        prefixSum = new int[nums.length];
        int curr = 0;
        for(int i=0;i<nums.length;i++){
             curr += nums[i];
             prefixSum[i] = curr;
        }
    }
    
    public int sumRange(int i, int j) {
        return i==0 ? prefixSum[j] : prefixSum[j] - prefixSum[i-1];
    }
}
