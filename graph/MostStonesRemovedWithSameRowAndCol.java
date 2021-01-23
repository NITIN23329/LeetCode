/*  approach :
      --> do a bfs on 2D array.
      --> add all points in a particular row and column.
      --> for every bfs find # of points visited.
      --> all points but 1 can be removed from the bfs done.
*/
class Solution {
    public int removeStones(int[][] stones) {
        Map<Integer,List<Integer>> adjRow = new HashMap<>();  // will store the column index for row
        Map<Integer,List<Integer>> adjCol = new HashMap<>();  // will store the row index for column
        for(int [] ele : stones){
            int r = ele[0];int c = ele[1];
            if(!adjRow.containsKey(r))adjRow.put(r,new ArrayList<>());
            if(!adjCol.containsKey(c))adjCol.put(c,new ArrayList<>());
            adjRow.get(r).add(c);
            adjCol.get(c).add(r);
        }
        int res = 0;
        Set<String> visited = new HashSet<>();
        for(int[] ele : stones)
            if(!visited.contains(ele[0]+","+ele[1]))
                    res+=bfs(adjRow,adjCol,ele[0],ele[1],visited)-1;
        return res;
    }
    private int bfs(Map<Integer,List<Integer>> adjRow,Map<Integer,List<Integer>> adjCol,int sx,int sy,Set<String> visited){
        Queue<int[]> q = new LinkedList<>();
        int c = 0;
        q.add(new int[]{sx,sy,-1});     // [a,b,c] = [ row , col , 1 if row is traverse, 0 if col is traversed]
        visited.add(sx+","+sy);         // by doing so, we need not to repeatedly travese row for every point in a particular row, same goes for col.
        while(!q.isEmpty()){
            int[] z = q.poll();
            c++;
            int x = z[0];int y = z[1];
            if(z[2]!=1){          // if row is not traversed
                for(int col : adjRow.get(x)){
                    if(!visited.contains(x+","+col)){
                        q.add(new int[]{x,col,1});
                        visited.add(x+","+col);
                    }
                }
            }
            if(z[2]!=0){        // if col is not traversed
                 for(int row : adjCol.get(y)){
                      if(!visited.contains(row+","+y)){
                       q.add(new int[]{row,y,0});
                       visited.add(row+","+y);
                    }
                 }
            }
        }
        return c;
    }
}
