public class NestedIterator implements Iterator<Integer> {

    private Deque<NestedInteger> dq;
    public NestedIterator(List<NestedInteger> nestedList) {
        dq = new ArrayDeque<>();
        adder(nestedList);
        
    }
    private void adder(List<NestedInteger> list){
        for(int i = list.size()-1;i>=0;i--){
            NestedInteger x= list.get(i);
            if(x.isInteger())dq.push(x);
            else adder(x.getList());
        }
    }
    @Override
    public Integer next() {
        return dq.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        return !dq.isEmpty();
    }
}
