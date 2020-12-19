//time : O( # of nodes + height * # of deepest nodes) space : O(height * # of deepest nodes))
/*  approach :
    --> find the height of tree
    --> find path of all deepest nodes from root to those nodes
    --> find the lca by traversing from deepest nodes to root. 
    --> for every path, if we found the current nodes is an ancestors for all other paths , then that current node is our answer
*/
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int height = findHeight(root);        
        List<LinkedList<TreeNode>> paths = new ArrayList<>();
        findPaths(root,paths,height,new LinkedList<>());
        List<Set<TreeNode>> sets = new ArrayList<>();
        for(int i=1;i<paths.size();i++){
            LinkedList<TreeNode> ll = paths.get(i);
            Set<TreeNode> ss = new HashSet<>();
            for(TreeNode ele : ll)ss.add(ele);
            sets.add(ss);
        }
        for(int i=paths.get(0).size()-1;i>=0;i--){
            TreeNode tt = paths.get(0).get(i);
            boolean isAll = true;
            for(Set<TreeNode> ele : sets)
                if(!ele.contains(tt)){
                    isAll = false;
                    break;
                }
            if(isAll)return tt;
        }
        return null;
    }
    
    private int findHeight(TreeNode root){
        if(root==null)return 0;
        return 1 + Math.max(findHeight(root.left),findHeight(root.right));
    }
    
    private void findPaths(TreeNode root,List<LinkedList<TreeNode>> paths,int height, LinkedList<TreeNode> list ){
        if(root==null)return;
        if(list.size()==height-1){
            LinkedList<TreeNode> temp = new LinkedList<>(list);
            temp.add(root);
            paths.add(temp);
            return;
        }
        list.addLast(root);
        findPaths(root.left,paths,height,list);
        findPaths(root.right,paths,height,list);
        list.removeLast();
    }
    
    
}
//time O(N) , space O(height)
/*
    approach :
        -->find the total number of deepest nodes = count
        --> for every node , check if the total # of deepest nodes known to it is = count , then the current node is a valid ancestors
        --> among such ancestors find the lowest one. 
        --> do post order traversal
            --> find how much deepest nodes is known to left node and right node recursively, if the sum==count , then current node know all deepest nodes
            --> the very first node to know all the deepest node is our answer
            --> one corner case is if the count==1 , then the deepest node is our answer.
*/
class Solution {
    private int maxH;
    private int count;
    private TreeNode res;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        count=0;maxH=0;
        res=null;
        findCount(root,0);
        lca(root,0);
        return res;
    }
    private void findCount(TreeNode root,int curr){
        if(root==null)return;
        if(curr==maxH)count++;
        else if(curr>maxH){
            maxH = curr;
            count=1;
        }
        findCount(root.left,curr+1);
        findCount(root.right,curr+1);
    }
    private int lca(TreeNode root,int curr){
        if(root==null)return 0;
        if(curr==maxH){
            if(count==1)res=root;
            return 1;
        }
        int x = lca(root.left,curr+1);
        int y = lca(root.right,curr+1);
        if(x+y==count && res==null)res=root;
        return x+y;
    }
}
