/*
  approach : using backtracking.
    --> as we need to visit in lexiographically order, sort the adjacency list so that smallest adjacent node visited first.
    --> we will be using visited edge and not visited nodes . Additionally as there can me more than 1 edge btw adjacent nodes,
        we need to store the edges with their freq in a hash map.
    --> start from "JFK" , traverse through all edges only 1 time, if we can traverse all edges then the path we followed is our result.
    --> we will use counter to keep track of # of edges remaining to visit.
    --> during backtracking,  reduce the freq of parent->curr edge by 1 , put curr to traversing path and reduce our counter by 1.
    --> recurively call for all adjacent edges
    --> if our counter reduces to 0 it means we traversed all edges hence return true and current traversing path is our result
    --> if we can not visit all edges from current node , increment the freq of parent-> curr edge by 1 , 
          remove curr to traversing path and increment our counter by 1 and return false.
*/
class Solution {
    private int counter;
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> adj = new HashMap<>();
        Map<String,Integer> visited = new HashMap<>();
        visited.put(",JFK",1);    // handling the starting of backtracking
        for(List<String> ele : tickets){
            String from = ele.get(0); String to = ele.get(1);
            if(!adj.containsKey(from))adj.put(from,new ArrayList<>());
            if(!adj.containsKey(to))adj.put(to,new ArrayList<>());
            adj.get(from).add(to);
            String edge = from+","+to;
            if(!visited.containsKey(edge))visited.put(edge,1);
            else visited.put(edge,visited.get(edge)+1);
        }
        for(String ele : adj.keySet())
            Collections.sort(adj.get(ele));
        LinkedList<String> order = new LinkedList<>();
        counter =  tickets.size();
        backtrack(adj,"JFK","",visited,order);
        return order;
        
    }
    private boolean backtrack(Map<String,List<String>> adj,String curr,String parent,Map<String,Integer> visited,  LinkedList<String> order){
        String conn = parent+","+curr;
        if(visited.get(conn)==0)return false;
        visited.put(conn,visited.get(conn)-1);
        order.addLast(curr);
        if(counter--==0)return true;
        for(String neig : adj.get(curr)){
            boolean x = backtrack(adj,neig,curr,visited,order);
            if(x)return true;
        }
        counter++;
        visited.put(conn,visited.get(conn)+1);
        order.removeLast();
        return false;  
    }
}
