//solution using basic math and length of linked list
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] arr = new ListNode[k];
        int n = 0;
        ListNode head=root;
        while(head!=null){
            head=head.next;
            n++;
        }
        if(n==0)return arr;
        int noOfNodes = n/k;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(noOfNodes);
        }
        noOfNodes = n%k;
        for(int i=0;i<k;i++){
             if(noOfNodes==0)break;
            noOfNodes--;
            list.set(i,list.get(i)+1);
           
        }
        head=root;
        arr[0]=root;
        ListNode past = null;
        for(int i=1;i<k;i++){
            int len = list.get(i-1);
            while(len-->0){
                past=head;
                head=head.next;
            }
            past.next=null;
            arr[i]=head;
        }
        return arr;
        
    }
}
