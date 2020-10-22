class StockSpanner {
    ArrayList<Integer> list;
    Deque<Integer> index;
    int c;
    public StockSpanner() {
        index = new ArrayDeque<>();
        int c=0;
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        while(!index.isEmpty() && list.get(index.peek())<=price)index.pop();
        int ans = index.isEmpty() ? list.size()+1 : list.size()-index.peek();
        list.add(price);
        index.push(c++);
        return ans;
    }
}
