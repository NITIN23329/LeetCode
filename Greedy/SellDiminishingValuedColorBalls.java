// time complexity : O(n + xlogx), space complexity : O(x), where x = # of distinct elements in inventory.
/*
    approach :
    --> The first thing that comes in mind is we try to take that color of ball whose freq of ball is maximum  from inventory first to maximize our profit sum.
    --> But what if we have more than one maximum value, then we take them alternatively.
    --> Since inventory[i] = 10^9 = orders, we can not process each order one by one.
    --> So suppose ball with maximum freq has color x and ball with nxt maximum freq has color y. How many times we will take x color balls before y color balls? 
        -->Exaclty x-y times untill freq of color x balls becomes freq of color y balls .
      --> After making their freq equal, we take them together alternatively.(take x color ball then y color ball then x color ball....)
    --> So first create an array(arr),which stores { value, freq of that value}, value means the # of balls of a particular color.
    --> Sort it in increasing order of value.
    --> Then we traverse from right to left.
    --> Let l = value at index i-1, r = value at index r, sameCount = freq of value at index r.
    --> We have 2 possibilities, we can take all ball values at index r and decrease all of them to value at index l.
      --> This is only possible if orders >= (r-l) * sameCount. By doing this all balls having value r is reduced to value l.
      --> After this we add all ball count having value l, sameCount += arr[i-1][1];
   --> Or we take cann't reduce all balls from value r to l. it is hard to solve this case, but taking an example make it easy.
      --> Let say we have r = 14 and sameCount = 4, and l = 10 and orders= 11,
      --> So we get profit in order: 14,14,14,14,13,13,13,13,12,12,12. 
      --> We try to first reduce all ball values together untill it is not possible to do so.But how many times we will take all balls together.
      --> takeAll = orders/sameCount will tell use the # of times we take all balls together.
      --> And the profit we get from it is sameCount * ( profit we get by  reducing  a particular color ball from r to r-takeAll)
      --> After reducing all of them, all balls have new value = r - takeAll.
      --> Now the remaining orders are takeRemainging = orders%sameCount.(We will not reduce all balls at a time but only reduce takeRemaining balls by 1 out of all balls)
      --> the profit we get by reducing  some balls = takeRemaining * (r - takeAll). 
      
*/
class Solution {
    public int maxProfit(int[] inventory, int orders) {
        // map will store the freq count of balls.
        Map<Integer,Integer> freqCount= new HashMap<>();
        for(int ele : inventory)
            freqCount.put(ele,freqCount.getOrDefault(ele,0)+1);
        int[][] arr = new int[freqCount.size()+1][2];
        // to handle case when we want to take all balls, then arr[0] holds l=0
        arr[0] = new int[]{0,1};
        int i = 1;
        for(int key : freqCount.keySet())
            arr[i++] = new int[]{key,freqCount.get(key)};
        // sort array in increasing order of the ball number
        Arrays.sort(arr,(a,b)->(a[0]-b[0]));
        int mod = (int)1e9+7;
        i = arr.length-1;
        long profit = 0;
        // same count will holds the # of balls of different color but having same count.
        long sameCount = arr[i][1];
        while(orders>0){
            long r = arr[i][0];
            long l = arr[i-1][0];
            long currTotal = (r-l)*sameCount;
            if(currTotal <= orders){
                orders -= currTotal;
                profit += sameCount * ((r*(r+1))/2 - ((l)*(l+1))/2);
            }
            else {
                long takeAll = orders/sameCount;
                long takeRemaining = orders%sameCount;
                orders -= takeAll * sameCount;
                profit += sameCount * ((r*(r+1))/2 - ((r-takeAll) * (r-takeAll+1))/2);
                orders -= takeRemaining;
                profit += takeRemaining * (r-takeAll);
            }
            sameCount+=arr[i-1][1];
            i--;
            profit %=mod;
        }
        return (int)profit;
    }
}
