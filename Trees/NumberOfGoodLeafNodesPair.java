//time O(n + leafs*2^10)
/*
  approach :
  --> find parent of each node for dfs traversal
  --> find all leaf nodes
  -->from every leaf node, do a dfs to atmost k distance and find which other leaf nodes are reachable
  --> after findind all leaf nodes atmost at a distance of k from current leaf node, mark current leaf node as done
*/
class Solution {
     Map<TreeNode,TreeNode> parent;
     List<TreeNode> leaf;
    Set<TreeNode> done;
    public int countPairs(TreeNode root, int distance) {
        parent = new HashMap<>();
        findParent(root,null);
        leaf= new ArrayList<>();
        findLeaf(root);
        done = new HashSet<>();
        int res=0;
        for(TreeNode start:leaf){
           res+= dfs(start,start,0,distance,new HashSet<>());
            done.add(start);
        }
        return res;
        
    }
    private void findParent(TreeNode curr,TreeNode prev){
        if(curr==null)return;
        parent.put(curr,prev);
        findParent(curr.left,curr);
        findParent(curr.right,curr);
    }
    private void findLeaf(TreeNode root){
        if(root==null)return;
        if(root.left==null && root.right==null){
            leaf.add(root);
            return;
        }
        findLeaf(root.left);
        findLeaf(root.right);
    }
    private int dfs(TreeNode start,TreeNode source,int curr,int k,Set<TreeNode> visited){
        if(start==null || curr>k || visited.contains(start))return 0;
        visited.add(start);
        if(start.left==null && start.right==null && start!=source)
            return !done.contains(start)? 1:0;   
        int l = dfs(start.left,source,curr+1,k,visited);
        int r = dfs(start.right,source,curr+1,k,visited);
        int p = dfs(parent.get(start),source,curr+1,k,visited);
        return l+r+p;
    }

}
//modification to above approach 
//we can remove use of done set because every pair will be added 2wice to our reuslt
// we can divide our result by 2 to get all pairs
class Solution {
     Map<TreeNode,TreeNode> parent;
     List<TreeNode> leaf;
    public int countPairs(TreeNode root, int distance) {
        parent = new HashMap<>();
        findParent(root,null);
        leaf= new ArrayList<>();
        findLeaf(root);
        int res=0;
        for(TreeNode start:leaf){
           res+= dfs(start,start,0,distance,new HashSet<>());
        }
        return res/2;
        
    }
    private void findParent(TreeNode curr,TreeNode prev){
        if(curr==null)return;
        parent.put(curr,prev);
        findParent(curr.left,curr);
        findParent(curr.right,curr);
    }
    private void findLeaf(TreeNode root){
        if(root==null)return;
        if(root.left==null && root.right==null){
            leaf.add(root);
            return;
        }
        findLeaf(root.left);
        findLeaf(root.right);
    }
    private int dfs(TreeNode start,TreeNode source,int curr,int k,Set<TreeNode> visited){
        if(start==null || curr>k || visited.contains(start))return 0;
        visited.add(start);
        if(start.left==null && start.right==null && start!=source)
            return 1;  
        int l = dfs(start.left,source,curr+1,k,visited);
        int r = dfs(start.right,source,curr+1,k,visited);
        int p = dfs(parent.get(start),source,curr+1,k,visited);
        return l+r+p;
    }

}
