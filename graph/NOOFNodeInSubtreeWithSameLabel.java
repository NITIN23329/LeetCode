// time complexity O(26*n) , space O(26*n)
/*  approach : 
      --> do a preorder traversal and find freq of all alphabets of all neighbour/children ,add them and add 1 to node's alphabet
      --> this gives frequencies of each alphabet of a tree starting from current node.
*/
class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<Node> adj = new ArrayList<>();
        for(int i=0;i<labels.length();i++)adj.add(new Node(labels.charAt(i)));
        for(int[] ele : edges){
            Node x = adj.get(ele[0]);
            Node y = adj.get(ele[1]);
            x.neig.add(y);
            y.neig.add(x);
            
        }
        preOrder(adj.get(0),null);
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            Node node = adj.get(i);
            res[i] = node.freq[node.c-'a'];
        }
        return res;
    }
    private void preOrder(Node root,Node parent){
        for(Node n : root.neig)
            if(parent!=n){
                 preOrder(n,root);
                for(int i=0;i<26;i++)
                    root.freq[i]+=n.freq[i];
            }
        root.freq[root.c-'a']++;
    }
}
class Node{
    char c;
    List<Node> neig;
    int[] freq;
    public Node(char c){
        this.c=c;
        neig = new ArrayList<>();
        freq = new int[26];
    }
}
