// time O(nklogk) , space O(k) , where n = size of each list , k = # of lists
/*  approach 1 : using heap
      --> add each list to min heap
      --> find the smallest value list , add it to result and goto next pointer in that list and add it to minheap
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->(a.val-b.val));
        for(ListNode l:lists){
            if(l!=null)pq.add(l);
        }
        ListNode head=null;
        ListNode iter = head;
        while(!pq.isEmpty()){
            ListNode x = pq.poll();
            if(iter==null){
                iter = new ListNode(x.val);
                head = iter;
            }
            else {
                iter.next = new ListNode(x.val);
                iter = iter.next;
            }
            x=x.next;
            if(x!=null)pq.add(x);
        }
        return head;
    }
}
// time O(nklogk) , space O(k)
/*  approach 2 : using recursion
  --> take 2 consecutive list, merge them and do this recursively until we left with 1 list only
*/
class Solution {
    public ListNode mergeKLists(ListNode[] list) {
        if(list.length==1)return list[0];
        if(list.length==0)return null;
        ListNode[] arr = new ListNode[(list.length+1)/2];
        int z=0;
        for(int i=0;i<list.length;i+=2){
            if(i+1==list.length){
                arr[z++] = list[i];
                break;
            }
            ListNode t = merge(list[i],list[i+1]);
            arr[z++]=t;
        }
        return mergeKLists(arr);
        
    }
    private ListNode merge(ListNode a,ListNode b){
        ListNode dummy = new ListNode(0);
        dummy.next = a;
        ListNode head=dummy;
        while(a!=null && b!=null){
            if(a.val<=b.val){
                dummy.next = a;
                a=a.next;
            }
            else{
                dummy.next = b;
                b=b.next;
            }
            dummy = dummy.next;
        }
        if(a != null)dummy.next = a;
        else dummy.next = b;
        return head.next;
    }
}
