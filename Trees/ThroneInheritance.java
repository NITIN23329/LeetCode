// birth() and death() require O(1) time 
// getInheritance() require O(n) time
// children will be stored in a list with its parent in a hashmap
// dead are stored in a set
class ThroneInheritance {
    Map<String,List<String>> map;
    Set<String> dead;
    String king;
    public ThroneInheritance(String kingName) {
        map = new HashMap<>();
        dead = new HashSet<>();
        map.put(kingName,new ArrayList<>());
        king = kingName;
    }
    
    public void birth(String parentName, String childName) {
       if(!map.containsKey(parentName))map.put(parentName,new ArrayList<>());
        map.get(parentName).add(childName);
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> list = new ArrayList<>();
        dfs(king,list);
        return list;
    }
    private void dfs(String curr,List<String> list){
        if(!dead.contains(curr))list.add(curr);
        if(!map.containsKey(curr))return;
        for(String ele : map.get(curr))
            dfs(ele,list);
    }
}
