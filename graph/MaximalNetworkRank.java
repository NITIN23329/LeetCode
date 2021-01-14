// time complexity O(v^2) , space complexity O(e+v)
/*  approach :
      --> store each edges in a map for every vertices
      --> consider all possible pairs (i,j) where i!=j , find maximum rank among all pairs
*/
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        int maxNode = 0;
        int maxConn = 0;
        for(int[] ele : roads){
            int x = ele[0];int y = ele[1];
            if(!map.containsKey(x))map.put(x,new HashSet<>());
            if(!map.containsKey(y))map.put(y,new HashSet<>());
            map.get(x).add(y);
            map.get(y).add(x);
        }
        int maxRank = 0;
        for(int i=0;i<n;i++){
            if(!map.containsKey(i))continue;
            int r1 = map.get(i).size();
            for(int j=i+1;j<n;j++){
                if(!map.containsKey(j))continue;
                int r2 = map.get(j).size();
                if(map.get(j).contains(i))r2--;
                maxRank = Math.max(maxRank,r1+r2);
            }
        }
        return maxRank;
    }
}
