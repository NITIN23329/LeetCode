// time taken : 2.4sec  ( TLE Solution but got accepted)
/*
->if n is even we can not form a Complete BT
->for every tree formed till now , do following until total # of nodes in tree = N
    ->find all possible combinations after adding 2 nodes in the current tree.
        ->for a current tree, find all leaf nodes where we can add 2(left and right) nodes.
        ->after finding the leaf nodes , we are sure that # of possible combination = # of leaf nodes cuz there are the places we gonna add new nodes
        ->clone the current tree , try all combiantions and all those which are not found yet
        -> we can find that a tree is created previously or not by taking level order
*/
class Solution {
    private List<List<TreeNode>> level;
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> list = new ArrayList<>();
        if(n%2==0)return list;
        TreeNode one = new TreeNode(0);
        list.add(one);
        level = new ArrayList<>();
        return find(list,1,n);
    }
    private List<TreeNode> find(List<TreeNode> list,int used,int n ){
        if(used==n)return list;
        List<TreeNode> newList = new ArrayList<>();
        for(TreeNode tree : list){
            List<TreeNode> curr = form(tree);
            newList.addAll(curr);
        }
        return find(newList,used+2,n);
    }
    private List<TreeNode> form(TreeNode root){
        List<TreeNode> leaf = new ArrayList<>();
        findAllLeafs(root,leaf);
        List<TreeNode> list = new ArrayList<>();
        for(TreeNode leafRef:leaf){
            TreeNode copy = clone(root);
            TreeNode target = findTarget(root,leafRef,copy);
            target.left = new TreeNode(0);
            target.right = new TreeNode(0);
            List<TreeNode> levelCurr = levelOrder(copy);
            if(!isPresent(levelCurr)){
                list.add(copy);
                level.add(levelCurr);
            }
            
        }
        return list;
    }
    private void findAllLeafs(TreeNode root,List<TreeNode> list){
        if(root.left==null && root.right==null){
            list.add(root);
            return ;
        }
        if(root.left!=null)findAllLeafs(root.left,list);
        if(root.right!=null)findAllLeafs(root.right,list);
    }
    private TreeNode clone(TreeNode orig){
        if(orig==null)return null;
        TreeNode copy = new TreeNode(0);
        copy.left=clone(orig.left);
        copy.right=clone(orig.right);
        return copy;
    }
    private TreeNode findTarget(TreeNode orig,TreeNode target,TreeNode copy){
        if(orig==target)return copy;
        if(orig==null)return null;
        TreeNode l = findTarget(orig.left,target,copy.left);
        if(l!=null)return l;
        return findTarget(orig.right,target,copy.right);
        
    }
    private List<TreeNode> levelOrder(TreeNode root){
        List<TreeNode> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode x = q.poll();
            list.add(x);
            if(x!=null){
                q.add(x.left);
                q.add(x.right);
            }
        }
        return list;
    }
    private boolean isPresent(List<TreeNode> list){
        boolean ans = false;
        for(List<TreeNode> ele : level){
            if(ele.size()!=list.size())continue;
            int i;
            for(i=0;i<ele.size();i++){
                if(ele.get(i)==null || list.get(i)==null){
                    if(ele.get(i)!=list.get(i))break;
                }
            }
            if(i==ele.size()){
                ans=true;
                break;
            }
        }
        return ans;
    }
}
