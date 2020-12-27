// time o(n) , space O(n)
// as we know that preorder of a bst is unique ,
//we store the preorder as string
// we from bst from that stored pre order
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder pre = new StringBuilder();
        preOrder(root,pre);
        return pre.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())return null;
        String[] pre = data.split(",");
        int[] index = new int[1];
        return formTree(pre,index,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
     private TreeNode formTree(String[] pre,int[] index,int l,int r){
        if(index[0]>=pre.length)return null;
        TreeNode root = new TreeNode(Integer.parseInt(pre[index[0]]));
        if(root.val<l || root.val>r)return null;
        index[0]++;
        root.left = formTree(pre,index,l,root.val-1);
        root.right =formTree(pre,index,root.val+1,r);
        return root;
    }
    private void preOrder(TreeNode root,StringBuilder str){
        Deque<TreeNode> dq = new ArrayDeque<>();
        while(!dq.isEmpty() || root!=null){
            while(root!=null){
                str.append(root.val).append(',');
                dq.push(root);
                root = root.left;
            }
            root = dq.pop().right;
        }
    }
   
}

