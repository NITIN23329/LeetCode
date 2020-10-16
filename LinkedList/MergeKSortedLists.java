//time complexity O(nlogk) , n = average length of list , k = no of list
class Solution {
    public ListNode mergeKLists(ListNode[] list) {
        if(list.length==1)return list[0];
        if(list.length==0)return null;
        ArrayList<ListNode> arr = new ArrayList<>();
        for(int i=0;i<list.length;i+=2){
            if(i+1==list.length){
                arr.add(list[i]);
                break;
            }
            ListNode t = merge(list[i],list[i+1]);
            arr.add(t);
        }
        list = new ListNode[arr.size()];
        for(int i=0;i<list.length;i++ )list[i] = arr.get(i);
        return mergeKLists(list);
        
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
