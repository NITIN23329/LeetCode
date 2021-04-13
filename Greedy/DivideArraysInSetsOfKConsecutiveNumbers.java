// time complexity : O(NlogN) and space complexity : O(N)
/*
    approach :
      --> First thing to note is that as we will divide our nums[] to groups of k numbers, len(nums[]) % k == 0.
      --> Each group size is = k.
      --> First we will put freq of each element in a map to use it in future grouping.
      --> req_freq will tell us the min freq we need to put elements consecutively in groups.
      --> We need to keep hold of starting element of group and its frequency. Let say starts.
      --> Suppose we are at element = curr and we need freq req_freq of it. If freq(curr) < req_freq it means we dont have sufficient curr elements to put them in each running groups hence return false.
      -->If freq(curr)> = req_freq, it means we can put curr element to all running groups and we need to start freq(curr) - req_freq extra groups.(in this case out new req_freq = freq(curr).
      --> And we need to delete those groups which have k elements full filled(staring element = curr - k + 1). starts map will tell us which groups reached their limit and we will reduce our req_freq.
      --> Upto this can be done in O(n) time.
      --> But there can be cases of disjoints groups like {1,2,3,4,5} and {10,11,12,13,14}. So we need to move from curr = 5 to curr = 10 immidiately.
      --> But when we will know we have to move? When curr is not present in nums[]. We can use TreeSet<> to find next greater element element in nums[].
      --> If there are no greater element it means we have traversed all emenets of nums and we can stop now.
*/
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k!=0)return false;
        Map<Integer,Integer> freq = new HashMap<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int ele : nums){
            freq.put(ele,freq.getOrDefault(ele,0)+1);
            treeSet.add(ele);
        }
        Map<Integer,Integer> starts = new HashMap<>();
        int req_freq = 0;
        int curr = 0;
        while(true){
            curr++;
            if(!freq.containsKey(curr)) {
                if(req_freq>0)return false;   // our req_freq is >0 but no consecutive element is there so retur false
                Integer next = treeSet.ceiling(curr);     // next element to start with
                if(next==null)break;      // if no next element we have reached to the end
                curr = next;        // else start doing same procedure for next element.
            }
            int curr_freq = freq.get(curr);
            if(curr_freq<req_freq)return false;
            if(curr_freq>req_freq)starts.put(curr,curr_freq-req_freq);
            req_freq = curr_freq;
            req_freq -= starts.getOrDefault(curr - k+1,0);
        }
        return true;
    }
}
