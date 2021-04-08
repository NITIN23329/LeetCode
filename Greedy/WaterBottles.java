/*.  time complexity : O(log(numBottles) / log(numExchange)), space complexity : O(1)
  --> approach :
  --> first we drink all full water bottles which is equal to numBottles.
  --> There for every group of numExchange empty bottles, we can get 1 full bottle, so we have numBottles/numExchange full bottles.
  --> There may be still some empty bottels < numexchange which are not exchanged yet. We store them in empty cuz they can be used in future.
  --> Next time we drink all numBottles, and exhange some of them  and there may be some empty bottles left,
  --> Again we add these empty bottles to our previous empty bottles and now if we make empty bottles>=numExchange, we use these left empty bottles and add empty/numExchange bottles to numBottles.
  --> Then we reduce our empty bottle by emply % numExchange. These bottles are not exchanged this time but may be in future.
  --> We do this until we have no full bottles left and our empty bottles < numExchange.
*/
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drink = 0;
        int empty = 0;
        while(numBottles>0 || empty>=numExchange){
            drink += numBottles;
            empty += numBottles%numExchange;
            numBottles /= numExchange;
            numBottles += empty/numExchange;
            empty %= numExchange;
        }
        return drink;
    }
}
