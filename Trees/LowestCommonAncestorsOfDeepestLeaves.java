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
