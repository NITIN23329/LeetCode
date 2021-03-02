public class LargestDivisibleSubset {
    // time complexity : O(N^2)
    // space complexity O(N)
    /*  approach :
            --> as the numbers can be appear in any order , we sort the given array so that for a numbers,its divisor appears before the number 
            --> let say for i>j, nums[i]%nums[j] == 0 , so this nums[i] will extend the sequence ending at nums[j]
            --> finding maximum length of such sequence is easy by using LIS variations, but how to find the sequence
            --> For this we will store previous index along with maximum length in dp array, if no such previous nums[j] is present we store -1 as index for nums[i]
            --> dp[i] = {max length of subsequence ending at index i , previous element's index of this subsequence}
            --> i.e. if nums[i] % nums[j] == 0 ,then dp[i] = { dp[j][0] , j}
    */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] dp = new int[n][2];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            dp[i] = new int[]{1,-1};
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i][0]<1+dp[j][0])
                    dp[i] = new int[]{dp[j][0]+1,j};
            }
            if(list.size()<dp[i][0]){
                int index = i;
                list = new ArrayList<>();
                while(index!=-1){
                    list.add(nums[index]);
                    index = dp[index][1];
                }
            }
        }
        return list;
    }
}
