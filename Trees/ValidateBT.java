// time and space complexity : O(n)
/*
  --> A BT has only one node having indegree 0(root) and rest all other nodes have indegree 1.
  --> A tree must be connected, i.e. , we should be able to visit all nodes from root node
*/
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree  = new int[n];
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(leftChild[i]!=-1)inDegree[leftChild[i]]++;
            if(rightChild[i]!=-1)inDegree[rightChild[i]]++;
        }
        int zeroInDegree = 0;
        int zeroDegreeNode = -1;
        for(int i=0;i<n;i++){
            if(inDegree[i] == 0){
                zeroInDegree++;
                zeroDegreeNode = i;
            }
            if(inDegree[i]>1)return false;
        }
        return zeroInDegree == 1 && dfs(zeroDegreeNode,visited,leftChild,rightChild) == n;
    }
    private int dfs(int curr,boolean[] visited,int[] leftChild, int[] rightChild){
        if(visited[curr])return 0;
        int ans = 1;
        visited[curr] = true;
        if(leftChild[curr]!=-1)
            ans +=dfs(leftChild[curr],visited,leftChild,rightChild);
        if(rightChild[curr]!=-1)
            ans += dfs(rightChild[curr],visited,leftChild,rightChild);
        return ans;
    }
}
