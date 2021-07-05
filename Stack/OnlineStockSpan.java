/*  --> O(1) amortized time complexity 
    --> if we simply find the # of days with price <= current price using the greater on right techinque , 
            the we gonna loose the information for future days as we will pop days with smaller prices in current day.
    --> Hence, for each day, along with the price we are gonna store the #of days where price is <=  for current day price 
        as well so that further calls will remeber the previously popped prices.
*/
class StockSpanner {
    Deque<int[]> dq;
    public StockSpanner() {
         dq = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int count = 1;
        while(!dq.isEmpty() && dq.peek()[0]<=price)count+=dq.pop()[1];
        dq.push(new int[]{price,count});
        return count;
    }
}
