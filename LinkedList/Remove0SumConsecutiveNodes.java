class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer,ListNode> map = new HashMap<>();
        int curr=0;
        ListNode iter=head;
        while(iter!=null){
            curr+=iter.val;
            if(curr==0){
                head = iter.next;
                 // remove all elements from map , so that previous values can not be misused
                map = new HashMap<>();
            }
            else if(map.containsKey(curr)){
                // remove all elements from map in between previous curr and present curr, so that previous values can not be misused
                //consider case : [1,3,2,-3,-2,5,5,-5,1] for more info
                ListNode rem = map.get(curr).next;
                int c = curr;
                while(rem!=iter){
                    c+=rem.val;
                    map.remove(c);
                    rem=rem.next;
                }
                map.get(curr).next = rem.next;
            }
            else map.put(curr,iter);
            iter=iter.next;
         }
        return head;
        
    }
}
