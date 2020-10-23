//approach 1 : 4ms time
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

//approach 2 : 2ms time
public class NestedIterator implements Iterator<Integer> {

    private Deque<NestedInteger> dq;
    public NestedIterator(List<NestedInteger> nestedList) {
        dq = new ArrayDeque<>();
        adder(nestedList);
        
    }
    private void adder(List<NestedInteger> list){
        for(int i = list.size()-1;i>=0;i--){
           dq.push(list.get(i));
        }
    }
    @Override
    public Integer next() {
       return dq.pop().getInteger();
    }
    //adder method is called in hasNext() and not in next() cuz consider test cas [[],[[[]]]] ,
    //here no integer but if we call adder in next then we have to return a integer which is not possible.
    @Override
    public boolean hasNext() {
       while(!dq.isEmpty() && !dq.peek().isInteger()){
           List<NestedInteger> l = dq.pop().getList();
           adder(l);
       }
        return !dq.isEmpty();
    }
}
