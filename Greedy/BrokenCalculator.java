// time complexity : O(log(Y-X)), space complexity : O(1)
/*
  --> Instead of doing multiplication and substraction to reach from x to y, we can do division and addition to frach from y to x.
  --> Why?
        [ With subtraction and multiplication, the effect of earlier subtraction will be amplified by later multiplications, hence, 
          greedily doing multiplication might not reach optimal solution as an additional early subtraction can have a huge effect
          (We need extra operations due to this effect)..   Whereas with addition and division, earlier addition will be diminished by later divisions. 
          It is thus always better to do division wherever possible. ]
  --> For explanation purpose we will use multiplication and substraction to goto right from left and division and addition to goto left fro right.
  --> Let say we are at y. There may be 2 cases,either y is odd or y is even.
  --> If y is odd, the previous operation must be the substraction one. Cuz if it had been an multplication by 2, we must have landed on an even number for sure.
  --> So we goto y+1 .
  --> Let say y is even, then the previous operation is either multplication by 2 or even consecutive substraction operation.
  --> If it had been multiplication, we goto y/2. 
  --> If it was the even consecutive substraction one let say we did 2 substraction.
      --> So one way is we were at (y/2+1) then we multiplied is by 2 to goto y + 2 and then we substracted 2 times. This takes 3 operation in total.
      --> Or we first goto y/2 and then add 1 to it to got (y/2+1) . Either way we reached to y/2+1 but the later one is more optimal(less operation).
 --> So for even y , we goto y/2 with any futhur issue. 

*/
class Solution {
    public int brokenCalc(int x, int y) {
        int count = 0;
        while(y>x){
            count += y%2;
            y+=y%2;
            y/=2;
            count++;
        }
        return x-y + count;
    }
}
