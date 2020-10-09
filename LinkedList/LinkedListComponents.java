class Solution {
    public int numComponents(ListNode head, int[] G) {
        int c=0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<G.length;i++)set.add(G[i]);
        int flag=0;
        while(head!=null)
        {
            if( head!=null && set.contains(head.val))
                flag=1;
            else if(flag==1){
                c++;
                flag=0;
            }
            head=head.next;
        
        }
        if(flag==1)c++;
        
        return c;
    }
}
