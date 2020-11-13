//time O(n)  ,  space O(1)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        while(root!=null){
            /*if there is no left child , then curr is smallest unvisited node ,
            *then visit it and goto right subtree*/
            if(root.left==null){
                list.add(root.val);
                root=root.right;
            }
            else{
                /*
                *here are 2 conditions,we visited left subtree and not visited left subree.
                *if we visited the left subtree then while finding the inorder predecessor , 
                we will definitely hit the current node. So unlink the inorder predecessor 
                , visit the current node and goto right subtree.
                * if we not visited the left subtree , find the inorder predecessor and link
                the right of it to current node.
                
                */
                TreeNode pred = root.left;
                while( pred.right!=null && pred.right!=root )pred=pred.right;
                if(pred.right==root){
                    pred.right=null;
                    list.add(root.val);
                    root = root.right;
                }
                else{
                    pred.right = root;
                    root = root.left;
                } 
                
            }
        }
        return list;
    }
}
