// time and space complexity : O(n)
/* 
  approach :
    let say our current element is x,
    if we know the Longest Arithmatic subsequence for x-diff , we can get ans of x by ans(x-diff) + 1 ,as  we are appending x after x-diff in sequence
    So we take a map , if we find x-diff in map , we put ans of x as ans(x-diff) +1
    else we put ans of x as 1 in map
 */
class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]-diff))
                map.put(arr[i],map.get(arr[i]-diff)+1);
            else map.put(arr[i],1);
            max = Math.max(max,map.get(arr[i]));
        }
        return max;
    }
}
