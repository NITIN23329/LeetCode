//time complexity O(nlogn) , space O(n)
/*  approach :
        --> this is a 2 step procedure
        1)first case is when the diff btw adjucent element is >1, we need to create new sequence and delete previouly created all sequence ,
          cuz we can not give a gap>1 to any seqence.  eg [1,2,3,6,7,8] = [1,2,3] , [6,7,8]
        2)when ever we encounter adjucent duplicates, we add each duplicate to other sequence , we can not add same value twice in a seqence,
        so # of sequece is max freqency. eg [ 1,2,2,3,3,4,4] = [1,2,3,4] , [2,3,4]
        3)all the remaining sequence after doing step 3 must be removed cuz any further element can not be added to remaing sequence cuz it will lead to a gap>1.
        eg : [4,5,6,6,7,8,9,10] = [4,5,6,8,9] , [6,7,8,10] , this is wrong
        after creating : [4,5,6] , [6,7] we need to delete 1st sequence so any further val can not be added to it : [6,7,8,9,10]
*/
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>(); //map will store the last index of every distinct element
        int n = nums.length;
        for(int i=0;i<n;i++)map.put(nums[i],i);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i;
        for(i=0;i<n;){
            if(i>0 && nums[i]-nums[i-1]>1){       //step 1
                while(!pq.isEmpty())if(pq.poll()<3)return false;
            }
            //step 2 
            int start = i;
            int end = map.get(nums[i]);
            List<Integer> list = new ArrayList<>();
            for(i=start;i<=end;i++){
                    if(pq.isEmpty())list.add(1);
                    else list.add(pq.poll()+1);
            }
            //step 3 
            while(!pq.isEmpty())if(pq.poll()<3)return false;
            for(int ele : list)pq.add(ele);
        }
         while(!pq.isEmpty())if(pq.poll()<3)return false;
        return true;
    }
}
