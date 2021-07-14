class CombinationIterator {

    public CombinationIterator(String characters, int combinationLength) {
        find(characters.toCharArray(),0,"",combinationLength);
    }
    Deque<String> q = new ArrayDeque<>();
    private void find(char [] str,int i,String curr,int k){
        if(curr.length()==k){
            q.add(curr);
            return;
        }
        if(str.length-i + curr.length()<k)return;
        find(str,i+1,curr+str[i],k);
        find(str,i+1,curr,k);
    }
    
    public String next() {
        return q.poll();
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }
}
