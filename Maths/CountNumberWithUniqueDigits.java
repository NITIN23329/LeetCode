// time complexity and space complexity O(1)
/*
    approach : consider n = 4
        --> unique # with 4 digits = 9 * 9 * 8 * 7    ( we have 9 choices top fill MSB bit (1 to 9) , we have 9 choices to fill MSB but 1 bit, we have then 8 choices to fill fill MSB but 2 bit....)
        --> unique # with 3 digits = 9 * 9 * 8 
        --> unique # with 2 digits = 9 * 9
        --> unique # with 1 digits = 9
        --> inique # with 0 digit  = 1 (0 itselft)
        --> So we add all above answers to get ans for n=4.
        
*/
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int ans = 1 ;    // when n == 0
        int curr = 9;
        for(int i=9;i>9-n;i--){
            ans+=curr;
            curr *=i;
        }
        return ans;    
    }
}
