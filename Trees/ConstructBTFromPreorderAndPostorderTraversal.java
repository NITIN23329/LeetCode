//time O(N) , spaceO(height)
/*  approach :
    --> store the post order and corresponding index in map
    --> find index of current node in post order
    --> find index of next current node in post order that will be in left subtree
    --> all values left to the next current node is in the left subtree of current node
    --> all values right to next current node  and left to curren node is the right subtree of current node
*/
class Solution {
    private Map<Integer,Integer> map;
    private int i;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
         map = new HashMap<>();
        for(i=0;i<post.length;i++)
            map.put(post[i],i);
        i=0;
        return form(pre,post.length,0,post.length-1);
    }
    private TreeNode form(int[] pre,int n,int l,int r){
        if(i==n)return null;
        if(l>r)return null;
        TreeNode root = new TreeNode(pre[i]);
        int x = map.get(root.val);
        i++;
        if(i==n)return root;
        int y = map.get(pre[i]);
        root.left = form(pre,n,l,x-1);
        root.right = form(pre,n,y+1,x-1);
        return root;
    }
}
