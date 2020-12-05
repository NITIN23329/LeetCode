// apprach 1 : time O(n+m) , space o(n+m)
//do inorder traversal of both trees , store them to differcent list , apply merge process to get sorted list

//approach 2 : time O(n+m) , space O(height1+height2)
/* 
  ->do a iterative inorder using stack until both roots become null and both stack becomes empty
  ->goto left subtree of both tree until we find null
  ->compare the top nodes of stack , add smaller one and goto right subtree of smaller one
  ->if one of the stack is null ,goto right subtree of other tree 
*/

class Solution {
    public List<Integer> getAllElements(TreeNode r1, TreeNode r2) {
        Deque<TreeNode> d2  = new ArrayDeque<>();
        Deque<TreeNode> d1  = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        while(r1!=null || r2!=null || !d1.isEmpty() || !d2.isEmpty()){
            while(r1!=null){
                d1.push(r1);
                r1 = r1.left;
            }
            while(r2!=null){
                d2.push(r2);
                r2=r2.left;
            }
            if(!d1.isEmpty() && !d2.isEmpty()){
                if(d1.peek().val<d2.peek().val){
                    r1=d1.pop();
                    list.add(r1.val);
                    r1=r1.right;
                }
                else{
                     r2 = d2.pop();
                    list.add(r2.val);
                    r2=r2.right;
                }
            }
            else if(d1.isEmpty()){
                    r2 = d2.pop();
                    list.add(r2.val);
                    r2=r2.right;
            }
            else if(d2.isEmpty()){
                    r1=d1.pop();
                    list.add(r1.val);
                    r1=r1.right;
            }
        }
        return list;
    }
   
}
