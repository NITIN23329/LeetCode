// time O(3*n)
/*  approach : do a bfs
      --> find all neighbour verteces's color
      --> the remainging color out of 4 is used to color current vertix
*/
class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
             adj.add(new ArrayList<>());
        for(int[]  ele : paths){
             int x = ele[0]-1;int y = ele[1]-1;
             adj.get(x).add(y);
             adj.get(y).add(x);
        }
        int[] flower = new int[n];
        for(int i=0;i<n;i++)
            if(flower[i]==0)
                bfs(adj,i,flower);
        return flower;
        
    }
    private void bfs(List<List<Integer>> adj, int curr,int[] flower){
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        while(!q.isEmpty()){
            int x = q.poll();
            if(flower[x]!=0)continue;
            int[] neigColor = new int[5];
            for(int neig : adj.get(x)){
                if(flower[neig]==0)q.add(neig);
                else neigColor[flower[neig]]=1;
            }
            for(int i=1;i<=4;i++)
                if(neigColor[i]==0){
                    flower[x] = i;
                    break;
                }
        }
    }
}
