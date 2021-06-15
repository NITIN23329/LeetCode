/*
    time complexity to preprocessing : O(nlogn)
    time complexity to getKthAncestor : O(logn)
*/
class TreeAncestor {
    int[][] binaryLift;
    int root = 0;
    public TreeAncestor(int n, int[] parent) {
        binaryLift = new int[n][20];
        for(int i=0;i<n;i++)Arrays.fill(binaryLift[i],-1);
        for(int i= 1;i<n;i++)
            binaryLift[i][0] = parent[i];
        for(int power=1;power<20;power++)
            for(int i=0;i<n;i++){
                int x = binaryLift[i][power-1];
                if(x==-1)continue;
                binaryLift[i][power] = binaryLift[x][power-1];
            }    
    }
    
    public int getKthAncestor(int node, int k) {
        for(int power=19;power>=0;power--){
            if(((1<<power) & k) > 0){
                node = binaryLift[node][power];
                k-=(1<<power);
            }
            if(node == -1)break;
        }
        return node;
    }
}
