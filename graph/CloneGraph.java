// time O(e+v) , space O(v)
/*  approach :
      --> do a dfs
      --> create clone node
      --> clone its neighbour using recursive dfs
      -->return coloned current node.
*/
class Solution {
    public Node cloneGraph(Node node) {
        return node==null ? null : dfs(node,new HashMap<>());
    }
    private Node dfs(Node node,Map<Integer,Node> isVisited){
        if(isVisited.containsKey(node.val))return isVisited.get(node.val);
        Node x = new Node(node.val);
        isVisited.put(node.val,x);  
        for(Node neig : node.neighbors)
            x.neighbors.add(dfs(neig,isVisited));
        return x;
    }
}
