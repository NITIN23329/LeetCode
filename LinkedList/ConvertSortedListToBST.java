class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)return null;
        ArrayList<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        return formTree(list,0,list.size()-1);
    
    }
    private TreeNode formTree(ArrayList<Integer> list,int s,int e){
        if(s>e)return null;
        int mid =(s+e)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = formTree(list,s,mid-1);
        root.right =formTree(list,mid+1,e);
        return root;
    }
}
