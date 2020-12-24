/* time O(n),space O(3*n), each node in tree will have at most 3 edges connected to it
  approach :
    --> out of given tree, form a undirected graph as 0<=node.val<=500
    --> do a dfs from given target node and find all nodes at a distance of k from it
*/
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<501;i++)adj.add(new ArrayList<>());
        formGraph(adj,root);
        boolean[] isVisited = new boolean[501];
        dfs(adj,target.val,list,0,k,isVisited);
        return list;
        
    }
    private void formGraph(ArrayList<ArrayList<Integer>> adj,TreeNode root){
        if(root.left!=null){
            adj.get(root.val).add(root.left.val);
            adj.get(root.left.val).add(root.val);
            formGraph(adj,root.left);
        }
        if(root.right!=null){
            adj.get(root.val).add(root.right.val);
            adj.get(root.right.val).add(root.val);
            formGraph(adj,root.right);
        }
    }
    private void dfs(ArrayList<ArrayList<Integer>> adj,int start,List<Integer> list,int curr,int k,boolean[] isVisited){
        if(isVisited[start])return;
        isVisited[start]=true;
        if(curr==k){
            list.add(start);
            return;
        }
        for(int child: adj.get(start))
            dfs(adj,child,list,curr+1,k,isVisited);
    }
}
//time O(n), space O(n)
/*
  approach : inspired by above solution
  --> as we know, each node has maximum of 3 edges connected to it, left node,right node ,and parent node
  --> we can store parent node of each node in map map
  --> do dfs from target node to find nodes at a distance of k
  --> for current node, we can go either to left node or right node or its parent node
*/
class Solution {
    Map<TreeNode,TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap<>();
        findParent(root,null);
        List<Integer> list = new ArrayList<>();
        dfs(target,list,0,k,new HashSet<>());
        return list;
    }
    private void findParent(TreeNode root,TreeNode prev){
        if(root==null)return;
        parent.put(root,prev);
        findParent(root.left,root);
        findParent(root.right,root);
    }
    private void dfs(TreeNode start,List<Integer> list,int curr,int k,Set<TreeNode> visited){
        if(start==null  || visited.contains(start))return ;
        visited.add(start);
        if(curr==k){
            list.add(start.val);
            return;
        }
        dfs(parent.get(start),list,curr+1,k,visited);
        dfs(start.left,list,curr+1,k,visited);
        dfs(start.right,list,curr+1,k,visited);
        
    }
    
}
