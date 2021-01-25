// time complexity O(n* 2^n)
/*  approach :
      --> draw a recursive tree diagram
      --> for every index,we have 2 choice either add current index element or not
        --> we can add current index element only if adding it results in non decreasing sequence
        --> we can always skip adding current index element.
*/
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        find(0,nums,res,new ArrayList<>(),set);
        return res;
    }
    private void find(int i,int[] nums,List<List<Integer>> res,List<Integer> curr,Set<String> set){
        if(i==nums.length){
            String sb = "";
            for(int ele : curr)sb+=ele+",";
            if(curr.size()>1 && !set.contains(sb)){
                res.add(new ArrayList<>(curr));
                set.add(sb);
            }
            return;
        }
        if(curr.size()==0 || curr.get(curr.size()-1)<=nums[i]){
            curr.add(nums[i]);
            find(i+1,nums,res,curr,set);
            curr.remove(curr.size()-1);
        }
        find(i+1,nums,res,curr,set);
    }
}
