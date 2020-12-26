//time O(n) , iterative level order using 1 queue
// with the help of a queue , do normal level order traversal
// if ltr , then add to last of level list
// else add to first of level list
// then toggle the ltr
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list  = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)return list;
        q.add(root);
        boolean ltr = true; //left to right toggler
        while(!q.isEmpty()){
            int s = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for(int i=0;i<s;i++){
                TreeNode x = q.poll();
                if(ltr)level.add(x.val);
                else level.addFirst(x.val);
                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
            }
            list.add(level);
            ltr = !ltr;
        }
        return list;
    }
}
//time O(N) , iterative level order using 2 stacks
// to 1st stack add right node then left
// to 2nd stack add left and then right
// so the other stack can read me reverse order
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> dq1 = new ArrayDeque<>();
        Deque<TreeNode> dq2 = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)return list;
        dq1.push(root);
        while(!dq1.isEmpty() || !dq2.isEmpty()){
            List<Integer> level = new ArrayList<>();
            while(!dq1.isEmpty()){
                TreeNode x = dq1.pop();
                level.add(x.val);
                if(x.left!=null)dq2.push(x.left);
                if(x.right!=null)dq2.push(x.right);
            }
            list.add(level);
            level = new ArrayList<>();
             while(!dq2.isEmpty()){
                TreeNode x = dq2.pop();
                level.add(x.val);
                if(x.right!=null)dq1.push(x.right);
                if(x.left!=null)dq1.push(x.left);
            }
            if(!level.isEmpty())
                list.add(level);
        }
        return list;
    }
}
