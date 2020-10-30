//time : O(n^2) , consider all contigious subarray
//space : O(1)
class Solution {
    public int longestWPI(int[] hours) {
        int res = 0;
        int curr = 0;
        for(int start = 0 ; start<hours.length;start++){
            curr = 0;
            for(int end = start ; end<hours.length;end++){
                if(hours[end]>8)curr++;
                else curr--;
                if(curr>0)res = Math.max(res , end-start+1);
            }
        }
        return res;
    }
}
//time O(n)  , using HashMap and prefixSum
//space O(n)
class Solution {
    public int longestWPI(int[] hours) {
        //will store prefix sum and its index
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;    
        int prefix = 0; //holds prefix sum upto i
        for(int i=0;i<hours.length;i++){
            // if hours[i]>0 then add 1 to prefix sum else -1
            prefix = hours[i]>8 ? prefix+1 : prefix-1;
            /* for any i, if prefix sum becomes positive , then all days uptil now 
            will create a well performing interval.
            */
            if(prefix>0)res = Math.max(res,i+1);
            /*
            if we get a current prefix sum which was seen already  then 2 case possible:
            Note:the reason why we are looking for same prefix sum is that in between 
            current index(included)  and previously seen same prefix's index (excluded), 
            there are same number of tiring and non-tiring days making both prefix sum 
            equal.
            1) if that previously
            seen prefix sum's index corresponds to a tiring day , our answer must include 
            that day also.
            2)else don't include that day in our answer and update prefix sum's index with
            current index as previouly seen prefix sum' index is a non tiring day so we 
            need not include that day to our result.
            */
            if(map.containsKey(prefix)){
                if(hours[map.get(prefix)]>8)
                    res = Math.max(res,i-map.get(prefix)+1);
                else { 
                     res = Math.max(res,i-map.get(prefix)-1);
                     map.put(prefix,i);   
                }
            
            }else map.put(prefix,i);
        }
        return res;
    }
}
